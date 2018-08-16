package org.onlinemall.dao.impl;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.onlinemall.dao.itf.UserDao;
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.domain.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //    日志
    public static Logger logger = Logger.getLogger("UserDaoImpl");
    static {
        logger.setLevel(Level.INFO);
    }

    @Override
    public void insert(User user) throws Exception {
        int userId = user.getUserId();
        String userName = user.getUserName();
        String userEmail = user.getUserEmail();
        String userPassword = user.getUserPassword();
        String userPortrait = user.getUserProtrait();
//        危险的操作，待重构
        Connection conn = new DBConnectionFactory().getConnection();
    }

    @Override
    public void update(User user) throws Exception {
//        暂不提供
    }

    @Override
    public void deletet(User user) throws Exception {
//        暂不提供
    }

//    使用id查询
    @Override
    public User queryById(int userId) throws Exception {
//        危险的操作
        Connection conn = new DBConnectionFactory().getConnection();

        return null;
    }
//    使用名称查询
    public User queryByName(String userName) throws Exception{
        User user = null;
        Connection conn = null;
        PreparedStatement preSta = null;
        ResultSet res = null;
//        危险的操作
        try {
            conn = new DBConnectionFactory().getConnection();
            String sql = "select * from user where user_id like "+"\""+userName+"\"";
            logger.info("sql:"+sql);
            preSta = conn.prepareStatement(sql);
            res = preSta.executeQuery();

            logger.info("resnext:"+res.next());

            while (res.next()){
                user = new User();
                user.setUserId(res.getInt("user_id"));
                user.setUserName(res.getString("user_name"));
                user.setUserEmail(res.getString("user_email"));
                user.setUserPassword(res.getString("user_password"));
                user.setUserPortrait(res.getString("user_portrait"));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try{
                res.close();
            }finally {
                try {
                    preSta.close();
                }finally {
                    conn.close();
                }
            }
        }
        return user;
    }
//    使用邮箱查询
    public User queryByEmail(String userEmail) throws Exception{
        return null;
    }

    @Override
    public List<User> queryAll() throws Exception {
        return null;
    }
}
