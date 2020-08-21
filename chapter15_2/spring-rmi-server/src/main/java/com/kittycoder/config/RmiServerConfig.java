package com.kittycoder.config;

import com.kittycoder.service.SpitterService;
import com.kittycoder.service.SpittleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * Created by shucheng on 2020/7/22 13:07
 */
@Configuration
@ComponentScan(basePackages = "com.kittycoder.service")
public class RmiServerConfig {

    @Autowired
    private SpitterService spitterService;
    @Autowired
    private SpittleService spittleService;

    /*@Bean
    public RmiServiceExporter serviceExporter() {
        RmiServiceExporter rse = new RmiServiceExporter();
        rse.setService(spitterService);
        rse.setServiceName("SpitterService");
        rse.setServiceInterface(SpitterService.class);
        return rse;
    }*/

    @Bean
    public HessianServiceExporter hessianServiceExporter() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }

    @Bean
    public BurlapServiceExporter burlapServiceExporter() {
        BurlapServiceExporter exporter = new BurlapServiceExporter();
        exporter.setService(spittleService);
        exporter.setServiceInterface(SpittleService.class);
        return exporter;
    }
}
