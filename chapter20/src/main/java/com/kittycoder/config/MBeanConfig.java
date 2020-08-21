package com.kittycoder.config;

import com.kittycoder.controller.SpittleController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;

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
    @Bean
    public MethodExclusionMBeanInfoAssembler assembler() {
        MethodExclusionMBeanInfoAssembler assembler = new MethodExclusionMBeanInfoAssembler();
        assembler.setIgnoredMethods("spittles");
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
    }
}
