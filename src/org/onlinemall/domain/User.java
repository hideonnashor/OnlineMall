package org.onlinemall.domain;

import java.util.Map;

public class User implements Bean<User>{

    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userProtrait;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserProtrait() {
        return userProtrait;
    }

    public void setUserPortrait(String userProtrait) {
        this.userProtrait = userProtrait;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public <User> User mapToBean(Map<String, Object> map) {
        this.setUserId((String) map.get("user_id"));
        this.setUserName((String) map.get("user_name"));
        this.setUserPassword((String) map.get("user_password"));
        this.setUserEmail((String) map.get("user_email"));
        this.setUserPortrait((String) map.get("user_portrait"));
        return (User) this;
    }
}
