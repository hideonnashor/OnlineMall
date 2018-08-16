package org.onlinemall.dao;

import org.onlinemall.dao.impl.CustomerDaoImpl;
import org.onlinemall.dao.impl.UserDaoImpl;
import org.onlinemall.dao.itf.CustomerDao;
import org.onlinemall.dao.itf.UserDao;

public class DaoFactory {

    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
