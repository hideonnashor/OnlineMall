package org.onlinemall.service.impl;

import org.onlinemall.dao.DaoFactory;
import org.onlinemall.dao.itf.UserDao;
import org.onlinemall.domain.User;
import org.onlinemall.service.itf.UserService;
import org.onlinemall.service.utils.GenerateUnique;

public class UserServiceImpl implements UserService {
    @Override
    public String signUp(User user) throws Exception {
        User newUser = null;

//        check the username and the useremail
        String userName = user.getUserName();
        String userEmail = user.getUserEmail();

        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();
        int flag = 0;
        if (userDao.queryByName(userName) != null){
            flag = 1;
        }else if (userDao.queryByEmail(userEmail) != null){
            flag = 2;
        }

        if (flag == 1){
            return "this username already existed";
        }else if (flag == 2){
            return "this email already existed";
        }else {
            newUser = new User();
            newUser.setUserId(GenerateUnique.generateUserId());
            newUser.setUserName(userName);
            newUser.setUserEmail(userEmail);
            newUser.setUserPassword(user.getUserPassword());
            userDao.insert(newUser);
            return "sign up succeed";
        }
    }
}
