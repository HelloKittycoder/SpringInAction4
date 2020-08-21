package com.kittycoder.config;

import com.kittycoder.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Created by shucheng on 2020/7/22 13:14
 */
@Configuration
public class RmiClientConfig {

    @Bean
    public RmiProxyFactoryBean spitterService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost/SpitterService");
        // rmiProxy.setServiceUrl("rmi://192.168.10.54/SpitterService");
        rmiProxy.setServiceInterface(SpitterService.class);
        return rmiProxy;
    }
}
