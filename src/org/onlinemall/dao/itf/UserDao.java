package org.onlinemall.dao.itf;

import org.onlinemall.domain.User;

import java.util.List;

public interface UserDao {
    public void insert(User user) throws Exception;
    public void update(User user) throws Exception;
    public void deletet(User user) throws Exception;
    public User queryById(int userId) throws Exception;
    public List<User> queryAll() throws Exception;
    public User queryByName(String userName) throws Exception;
    public User queryByEmail(String userEmail) throws Exception;
}
