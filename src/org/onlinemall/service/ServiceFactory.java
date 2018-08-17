package org.onlinemall.service;

import org.onlinemall.service.impl.UserServiceImpl;
import org.onlinemall.service.itf.UserService;

public class ServiceFactory {
    private static ServiceFactory serviceFactory = null;

    private ServiceFactory() {

    }

    public static ServiceFactory getServiceFactory(){
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
            return serviceFactory;
        }else {
            return serviceFactory;
        }
    }

    public UserService getUserService(){
        UserService userService = new UserServiceImpl();
        return userService;
    }

}
