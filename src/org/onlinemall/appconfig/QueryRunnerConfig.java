package org.onlinemall.appconfig;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryRunnerConfig {

    @Bean
    public QueryRunner queryRunner(){
        return new QueryRunner();
    }
}
