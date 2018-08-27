package org.onlinemall.appconfig;

import org.onlinemall.domain.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryBeanConfig {
    @Bean
    public Category category(){
        return new Category();
    }
}
