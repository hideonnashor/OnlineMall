package org.onlinemall.dao;

public class DaoFactory {

    public Dao getUserDao(){
        return new CustomerDaoImpl();
    }
}
