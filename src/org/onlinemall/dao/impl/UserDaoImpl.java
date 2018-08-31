package org.onlinemall.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.onlinemall.dao.itf.UserDao;
import org.onlinemall.dao.util.DBConnectionFactory;
import org.onlinemall.domain.User;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    //    日志
    public static Logger logger = Logger.getLogger("UserDaoImpl");
    static {
        logger.setLevel(Level.INFO);
    }

    @Override
    public void insert(User user) throws Exception {
        String userId = user.getUserId();
        String userName = user.getUserName();
        String userEmail = user.getUserEmail();
        String userPassword = user.getUserPassword();
        String userPortrait = user.getUserProtrait();
//        dbutils
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnectionFactory.getDBConnectionFactory().getMysqlConnection();
        try {
            String sql = "insert into user values (?,?,?,?,?)";
            Object[] params = {userId,userName,userEmail,userPassword,userPortrait};
            qr.update(conn,sql,params);
        }finally {//        创建queryrunner未使用datasource，手动关闭连接
            conn.close();
        }
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
//
        Connection conn = DBConnectionFactory.getDBConnectionFactory().getMysqlConnection();

        return null;
    }
//    使用名称查询
    public User queryByName(String userName) throws Exception{
        User user = null;
//        dbutils
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnectionFactory.getDBConnectionFactory().getMysqlConnection();
        try {
            String sql = "select * from user where user_name like ?";
            Map<String,Object> userMap = qr.query(conn,sql,new MapHandler(),userName);
            if (userMap!=null){
                user = new User();
                user.mapToBean(userMap);
            }
            return user;
        }finally {
            conn.close();
        }
    }

//    使用邮箱查询
    public User queryByEmail(String userEmail) throws Exception{
        User user = null;
//        dbutils
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnectionFactory.getDBConnectionFactory().getMysqlConnection();
        try {
            String sql = "select * from user where user_email like ?";
            Map<String,Object> userMap = qr.query(conn,sql,new MapHandler(),userEmail);
            if (userMap!=null){
                user = new User();
                user.mapToBean(userMap);
            }
            return user;
        }finally {
            conn.close();
        }
    }

    @Override
    public List<User> queryAll() throws Exception {
        return null;
    }
}
