package org.onlinemall.dao.util;

import redis.clients.jedis.Jedis;

import java.sql.Connection;

public class DBConnectionFactory {
    private static DBConnectionFactory dbConnectionFactory = null;

    private DBConnectionFactory(){}

    public static DBConnectionFactory getDBConnectionFactory(){
        if (dbConnectionFactory == null){
            dbConnectionFactory = new DBConnectionFactory();
            return dbConnectionFactory;
        }else {
            return dbConnectionFactory;
        }
    }

    public Connection getMysqlConnection(){
        DBGetConnection mySqlGetConnection = new MySqlGetConnection();
        return mySqlGetConnection.getConnection();
    }
    public Jedis getRedisConnection(){
        RedisGetConnection redisGetConnection = new RedisGetConnection();
        return redisGetConnection.getConnection();
    }
}
