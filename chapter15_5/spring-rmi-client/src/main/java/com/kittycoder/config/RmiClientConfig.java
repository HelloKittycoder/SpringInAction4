package com.kittycoder.config;

import com.kittycoder.service.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shucheng on 2020/7/22 13:14
 */
@Configuration
public class RmiClientConfig {

    /*@Bean
    public RmiProxyFactoryBean spitterService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost/SpitterService");
        rmiProxy.setServiceInterface(SpitterService.class);
        return rmiProxy;
    }*/

    /*@Bean
    public HessianProxyFactoryBean spitterService() {
        HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }

    @Bean
    public BurlapProxyFactoryBean spittleService() {
        BurlapProxyFactoryBean proxy = new BurlapProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/spittle.service");
        proxy.setServiceInterface(SpittleService.class);
        return proxy;
    }*/

    /*@Bean
    public HttpInvokerProxyFactoryBean spitterService() {
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/spitter.service");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }*/

    @Bean
    public JaxWsPortProxyFactoryBean spitterService() throws Exception {
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        proxy.setWsdlDocumentUrl(new URL("http://localhost:8080/SpitterService?wsdl"));
        proxy.setServiceName("SpitterService");
        proxy.setPortName("SpitterServiceEndpointPort");
        proxy.setServiceInterface(SpitterService.class);
        proxy.setNamespaceUri("http://endpoint.kittycoder.com/");
        return proxy;
    }
}
