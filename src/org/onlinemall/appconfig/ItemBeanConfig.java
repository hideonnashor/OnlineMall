package org.onlinemall.appconfig;

import org.onlinemall.domain.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ItemBeanConfig {

    @Bean
    @Scope(value = "prototype")
    public Item item(){
        return new Item();
    }
}
