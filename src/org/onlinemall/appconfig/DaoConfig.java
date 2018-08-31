package org.onlinemall.appconfig;

import org.onlinemall.dao.impl.UserDaoImpl;
import org.onlinemall.dao.itf.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }
}
