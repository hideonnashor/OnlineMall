package org.onlinemall.dao;

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

public class DBUtils {

//    日志
    public static Logger logger = Logger.getLogger("DBUtils");
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
        InputStream dbIn = DBUtils.class.getClassLoader().getResourceAsStream("org/onlinemall/dao/dbData.properties");
        try {
    //        read the data from property file
            pro.load(dbIn);
            dbDriver=pro.getProperty("driver");
            dbUrl=pro.getProperty("url");
            dbUsername=pro.getProperty("username");
            dbPassword=pro.getProperty("password");
            dbConnectionsize= Integer.parseInt(pro.getProperty("connectionsize"));
            logger.info("read properties succeed");
    //        load the driver
            Class.forName(dbDriver);
            for (int i = 0; i < dbConnectionsize; i++) {
                Connection conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
                conns.add(conn);
            }
            logger.info("connection initial");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        if (conns.size() == 0) {
            throw new NullPointerException("run out of connections");
        }else {
            Connection conn = (Connection) conns.removeFirst();
            return (Connection) Proxy.newProxyInstance(DBUtils.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (!method.getName().equalsIgnoreCase("close")) {
                        return method.invoke(conn,args);
                    }else {
                        conns.add(conn);
                        logger.info("connection return");
                        return null;
                    }
                }
            });
        }
    }
}
