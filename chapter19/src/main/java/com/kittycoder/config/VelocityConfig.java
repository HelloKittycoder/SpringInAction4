package com.kittycoder.config;

import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import java.util.Properties;

/**
 * @author shucheng
 * @date 2022/9/29 22:03
 */
@Configuration
public class VelocityConfig {

    @Bean
    public VelocityEngineFactoryBean velocityEngine() {
        VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
        Properties props = new Properties();
        props.setProperty("resource.loader", "class");
        props.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.setVelocityProperties(props);
        return velocityEngine;
    }
}
