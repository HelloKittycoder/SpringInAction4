package com.kittycoder.external.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by shucheng on 2020/6/27 14:08
 */
@Configuration
@PropertySource("classpath:com/kittycoder/external/app.properties")
@ComponentScan("com.kittycoder.external.properties")
public class PropertiesJavaConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
