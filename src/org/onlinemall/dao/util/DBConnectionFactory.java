package org.onlinemall.dao.util;

import java.sql.Connection;

public class DBConnectionFactory {
    public Connection getConnection(){
        DBGetConnection mySqlGetConnection = new MySqlGetConnection();
        return mySqlGetConnection.getConnection();
    }
}
