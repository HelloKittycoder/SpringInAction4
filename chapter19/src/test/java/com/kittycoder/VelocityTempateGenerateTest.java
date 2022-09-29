package com.kittycoder;

import com.kittycoder.config.VelocityConfig;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 19.3.1 使用Velocity构建Email消息
 * @author shucheng
 * @date 2022/9/29 22:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = VelocityConfig.class)
public class VelocityTempateGenerateTest {

    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void test() {
        Map<String, Object> model = new HashMap<>();
        model.put("spitterName", "coffie");
        model.put("spittleText", "Hiya!");
        String renderedStr = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "vmtemplate/emailtemplate/mailtemplate.vm",
                "UTF-8", model);
        System.out.println(renderedStr);
    }
}
