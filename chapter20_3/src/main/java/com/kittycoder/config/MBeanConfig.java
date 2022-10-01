package com.kittycoder.config;

import com.kittycoder.controller.SpittleController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.jmx.support.RegistrationPolicy;

import java.util.HashMap;
import java.util.Map;

/**
 * 为了测试MBean冲突，这里加一个ConflictController，MBean注册的名字和SpittleController保持一致
 *
 * RegistrationPolicy 处理MBean名字冲突的机制：
 * FAIL_ON_EXISTING 如果已存在相同名字的MBean，则提示失败（默认行为）
 * IGNORE_EXISTING 忽略冲突，同时也不注册新的MBean
 * REPLACE_EXISTING 用新的MBean覆盖已存在的MBean
 *
 * 补充：MBean注册同名的bean时顺序无法控制，这里如果有冲突的话，需要结合实际注册顺序来确定用哪种冲突处理策略
 * 一般情况下，直接用默认的FAIL_ON_EXISTING就好了，如果出现重名的情况，手动改个新名字，不要和已有的重名
 *
 * Created by shucheng on 2020/7/31 23:45
 */
@Configuration
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
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
}
