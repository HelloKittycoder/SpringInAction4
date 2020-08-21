package com.kittycoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shucheng on 2020/7/26 12:46
 */
@ComponentScan(basePackages = "com.kittycoder")
public class TestBeanConfig {

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}
