package com.kittycoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import java.net.MalformedURLException;

/**
 * 通过MBeanServerConnection访问远程MBean的配置（直接访问）
 *
 * 20.2.2 访问远程MBean
 *
 * @author shucheng
 * @date 2022/10/1 16:08
 */
@Configuration
public class MBeanClientConfig {

    @Bean
    public MBeanServerConnectionFactoryBean connection() throws MalformedURLException {
        // System.out.println("该方法connection被执行了");
        MBeanServerConnectionFactoryBean mbscfb = new MBeanServerConnectionFactoryBean();
        mbscfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1199/spitter");
        return mbscfb;
    }
}
