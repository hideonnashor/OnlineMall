package org.onlinemall.dao;

import org.onlinemall.dao.impl.CustomerDaoImpl;
import org.onlinemall.dao.impl.UserDaoImpl;
import org.onlinemall.dao.itf.CustomerDao;
import org.onlinemall.dao.itf.UserDao;

public class DaoFactory {
    private static DaoFactory daoFactory = null;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        if (daoFactory == null){
            daoFactory = new DaoFactory();
            return daoFactory;
        }else {
            return daoFactory;
        }

    }

    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
