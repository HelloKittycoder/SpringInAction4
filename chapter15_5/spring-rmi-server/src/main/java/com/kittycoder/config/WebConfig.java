package com.kittycoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

/**
 * Created by shucheng on 2020/7/22 23:25
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.kittycoder.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    /*@Bean
    public HandlerMapping hessianMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/spitter.service", "httpInvokerServiceExporter");
        mapping.setMappings(mappings);
        return mapping;
    }*/
}
