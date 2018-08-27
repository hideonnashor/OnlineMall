package org.onlinemall.service.impl;

import org.onlinemall.dao.DaoFactory;
import org.onlinemall.dao.itf.UserDao;
import org.onlinemall.domain.User;
import org.onlinemall.service.itf.UserService;
import org.onlinemall.utils.GenerateUnique;

public class UserServiceImpl implements UserService {
    @Override
    public String signUp(User user) throws Exception {
        User newUser = null;

//        check the username and the useremail

        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();
        int flag = 0;
        if (userDao.queryByName(user.getUserName()) != null){
            flag = 1;
        }else if (userDao.queryByEmail(user.getUserEmail()) != null){
            flag = 2;
        }

        if (flag == 1){
            return "this username already existed";
        }else if (flag == 2){
            return "this email already existed";
        }else {
            newUser = new User();
            newUser.setUserId(GenerateUnique.generateUserId());
            newUser.setUserName(user.getUserName());
            newUser.setUserEmail(user.getUserEmail());
            newUser.setUserPassword(user.getUserPassword());
            newUser.setUserPortrait("");
            userDao.insert(newUser);
            return "sign up succeed";
        }
    }

    @Override
    public User signIn(User user, String type) throws Exception {
        UserDao userDao = DaoFactory.getDaoFactory().getUserDao();

//         使用name登陆
        if (type.equalsIgnoreCase("name")){
            User userSearchByName = userDao.queryByName(user.getUserName());
            if (userSearchByName!=null){
                user = user.getUserPassword().equals(userSearchByName.getUserPassword())? userSearchByName:null;
                return user;
            }
            return null;
        }
//        使用email登陆
        User userSearchByEmail = userDao.queryByEmail(user.getUserEmail());
        if (userSearchByEmail!=null){
            user = user.getUserPassword().equals(userSearchByEmail.getUserPassword())?userSearchByEmail:null;
            return user;
        }
        return null;
    }
}
