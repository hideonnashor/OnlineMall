package org.onlinemall.appconfig;

import org.onlinemall.domain.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemBeanConfig {

    @Bean
    public Item item(){
        return new Item();
    }
}
