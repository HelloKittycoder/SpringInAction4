package com.kittycoder.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by shucheng on 2020/6/27 13:55
 */
@Configuration
public class EnvironmentConfigWithRequiredProperties {

    @Autowired
    private Environment env;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(env.getRequiredProperty("disc.title"),
                env.getRequiredProperty("disc.artist"));
    }
}
