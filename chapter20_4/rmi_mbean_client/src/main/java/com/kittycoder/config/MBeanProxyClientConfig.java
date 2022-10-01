package com.kittycoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import java.net.MalformedURLException;

/**
 * 通过MBeanProxyFactoryBean访问远程MBean的配置（用代理访问）
 * 这种方式相当于把和远程MBean的交互，变得像和本地Bean一样了
 *
 * 20.2.3 代理MBean
 *
 * @author shucheng
 * @date 2022/10/1 19:52
 */
@Configuration
public class MBeanProxyClientConfig {

    @Bean
    public MBeanServerConnectionFactoryBean connection() throws MalformedURLException {
        // System.out.println("该方法connection被执行了");
        MBeanServerConnectionFactoryBean mbscfb = new MBeanServerConnectionFactoryBean();
        mbscfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1199/spitter");
        return mbscfb;
    }

    @Bean
    public MBeanProxyFactoryBean remoteSpittleControllerMBean(MBeanServerConnection mBeanServerConnection) throws MalformedObjectNameException {
        MBeanProxyFactoryBean proxy = new MBeanProxyFactoryBean();
        proxy.setObjectName("spitter:name=SpittleController");
        proxy.setServer(mBeanServerConnection);
        proxy.setProxyInterface(SpittleControllerManagedOperations.class);
        return proxy;
    }
}
