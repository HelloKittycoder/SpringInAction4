package com.kittycoder.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by shucheng on 2020/6/27 13:09
 */
@Configuration
@PropertySource("classpath:com/kittycoder/external/app.properties")
public class EnvironmentConfig {

    @Autowired
    private Environment env;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(env.getProperty("disc.title"),
                env.getProperty("disc.artist"));
    }
}
