package org.onlinemall.dao;

import org.onlinemall.dao.impl.CategoryDapImpl;
import org.onlinemall.dao.impl.ItemDaoImpl;
import org.onlinemall.dao.impl.UserDaoImpl;
import org.onlinemall.dao.itf.CategoryDao;
import org.onlinemall.dao.itf.ItemDao;
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
    public CategoryDao getCategoryDao() {
        return new CategoryDapImpl();
    }
    public ItemDao getItemDao(){
        return new ItemDaoImpl();
    }
}
