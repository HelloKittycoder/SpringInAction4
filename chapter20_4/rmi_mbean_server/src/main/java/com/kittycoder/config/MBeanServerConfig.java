package com.kittycoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

/**
 * Created by shucheng on 2020/7/31 23:45
 */
@Configuration
@EnableMBeanExport
public class MBeanServerConfig {

    // 暴露远程MBean
    @Bean
    @DependsOn(value = "rmiRegistry")
    public ConnectorServerFactoryBean connectorServer() {
        // System.out.println("connectorServer被调用了");
        ConnectorServerFactoryBean csfb = new ConnectorServerFactoryBean();
        csfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1199/spitter");
        return csfb;
    }

    // 启动RMI注册表
    @Bean
    public RmiRegistryFactoryBean rmiRegistry() {
        // System.out.println("rmiRegistry被调用了");
        RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
        // RMI注册表默认监听本机的1099端口
        rmiRegistryFactoryBean.setPort(1199);
        return rmiRegistryFactoryBean;
    }
}
