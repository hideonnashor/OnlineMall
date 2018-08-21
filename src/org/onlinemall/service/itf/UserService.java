package org.onlinemall.service.itf;

import org.onlinemall.domain.User;

public interface UserService {
    public String signUp(User user) throws Exception;
    public User signIn(User user,String type) throws Exception;
}
