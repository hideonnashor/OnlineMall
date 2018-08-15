package org.onlinemall.dao.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class MySqlGetConnection implements DBGetConnection {

//    日志
    public static Logger logger = Logger.getLogger("MySqlGetConnection");
    static {
        logger.setLevel(Level.INFO);
    }

//    driver
    private static String dbDriver;
//    url
    private static String dbUrl;
//    username
    private static String dbUsername;
//    password
    private static String dbPassword;
//    connection quantity
    private static int dbConnectionsize;
    private static LinkedList conns = new LinkedList();

    static{
        Properties pro = new Properties();
        InputStream dbIn = MySqlGetConnection.class.getClassLoader().getResourceAsStream("org/onlinemall/dao/util/dbData.properties");
        try {
    //        read the data from property file
            pro.load(dbIn);
            dbDriver=pro.getProperty("mydriver");
            dbUrl=pro.getProperty("myurl");
            dbUsername=pro.getProperty("myusername");
            dbPassword=pro.getProperty("mypassword");
            dbConnectionsize= Integer.parseInt(pro.getProperty("connectionsize"));
            logger.info("[loginfo]:read properties succeed");
    //        load the driver
            Class.forName(dbDriver);
            for (int i = 0; i < dbConnectionsize; i++) {
                Connection conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
                conns.add(conn);
            }
            logger.info("[loginfo]:connection initial");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Connection getConnection(){
        if (conns.size() == 0) {
            throw new NullPointerException("run out of connections");
        }else {
            Connection conn = (Connection) conns.removeFirst();
            return (Connection) Proxy.newProxyInstance(MySqlGetConnection.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (!method.getName().equalsIgnoreCase("close")) {
                        return method.invoke(conn,args);
                    }else {
                        conns.add(conn);
                        logger.info("[loginfo]:connection return");
                        return null;
                    }
                }
            });
        }
    }
}
