package org.onlinemall.dao.util;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RedisGetConnection {
    private static String reurl;
    private Jedis jedis;

    static{
        Properties pro = new Properties();
        InputStream dbIn = RedisGetConnection.class.getClassLoader().getResourceAsStream("org/onlinemall/dao/util/dbData.properties");
        try {
            //        read the data from property file
            pro.load(dbIn);
            reurl = pro.getProperty("reurl");
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public Jedis getConnection() {
        jedis = new Jedis(reurl);
        return jedis;
    }
}
