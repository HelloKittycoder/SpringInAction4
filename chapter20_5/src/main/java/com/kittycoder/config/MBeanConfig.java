package com.kittycoder.config;

import com.kittycoder.listener.PagingNotificationListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.export.MBeanExporter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shucheng
 * @date 2022/10/1 21:54
 */
@Configuration
@EnableMBeanExport
public class MBeanConfig implements BeanPostProcessor {

    @Autowired
    private PagingNotificationListener pagingNotificationListener;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("mbeanExporter".equals(beanName)) {
            MBeanExporter exporter = (MBeanExporter) bean;
            Map<String, PagingNotificationListener> mappings = new HashMap<>();
            mappings.put("spitter:name=SpitterNotifier",
                    pagingNotificationListener);
            // 之前照着书上的给的源码，写的是下面的对应关系。这个对应关系是错的，这样肯定收不到SpittleNotifierImpl发来的通知
            /*mappings.put("spitter:name=PagingNotificationListener",
                    pagingNotificationListener);*/
            exporter.setNotificationListenerMappings(mappings);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
