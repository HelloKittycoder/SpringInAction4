package com.kittycoder.environment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by shucheng on 2020/6/26 21:14
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource oracle() {
        return new DataSource("oracle");
    }

    @Bean
    @Profile("prod")
    public DataSource mysql() {
        return new DataSource("mysql");
    }
}
