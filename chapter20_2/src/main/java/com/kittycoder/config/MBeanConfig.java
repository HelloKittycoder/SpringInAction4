package com.kittycoder.config;

import com.kittycoder.controller.SpittleController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import javax.management.MBeanServer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shucheng on 2020/7/31 23:45
 */
@Configuration
public class MBeanConfig {

    /**
     * 配置需要包含到MBean的方法
     * @return
     */
    /*@Bean
    public MethodNameBasedMBeanInfoAssembler assembler() {
        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
        assembler.setManagedMethods(new String[] {
                "getSpittersPerPage", "setSpittersPerPage"
        });
        return assembler;
    }*/

    /**
     * 配置不需要变成MBean的方法
     * @return
     */
    /*@Bean
    public MethodExclusionMBeanInfoAssembler assembler() {
        MethodExclusionMBeanInfoAssembler assembler = new MethodExclusionMBeanInfoAssembler();
        assembler.setIgnoredMethods("spittles");
        return assembler;
    }*/

    /**
     * 通过接口来标识要包含到MBean的方法
     * @return
     */
    /*@Bean
    public InterfaceBasedMBeanInfoAssembler assembler() {
        InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();
        assembler.setManagedInterfaces(new Class<?>[] { SpittleControllerManagedOperations.class });
        return assembler;
    }

    @Bean
    public MBeanExporter mBeanExporter(SpittleController spittleController, MBeanInfoAssembler assembler) {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("spitter:name=SpittleController", spittleController);
        exporter.setBeans(beans);
        exporter.setAssembler(assembler);
        return exporter;
    }*/

    @Bean
    public MBeanServerFactoryBean mbeanServer() {
        MBeanServerFactoryBean factoryBean = new MBeanServerFactoryBean();
        return factoryBean;
    }

    @Bean
    public MBeanExporter mBeanExporter(MBeanServer mBeanServer) {
        MBeanExporter exporter = new MBeanExporter();
        exporter.setServer(mBeanServer);
        return exporter;
    }
}
