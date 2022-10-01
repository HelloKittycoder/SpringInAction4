package com.kittycoder.config;

import com.kittycoder.listener.PagingNotificationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
public class MBeanConfig {

    @Autowired
    private PagingNotificationListener pagingNotificationListener;

    @Bean
    public MBeanExporter mBeanExporter() {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, PagingNotificationListener> mappings = new HashMap<>();
        mappings.put("spitter:name=PagingNotificationListener",
                pagingNotificationListener);
        exporter.setNotificationListenerMappings(mappings);
        return exporter;
    }
}
