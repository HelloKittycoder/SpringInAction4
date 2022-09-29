package com.kittycoder;

import com.kittycoder.config.ThymeleafConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 19.3.2 使用Thymeleaf构建Email消息
 * @author shucheng
 * @date 2022/9/29 22:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ThymeleafConfig.class)
public class ThymeleafTemplateGenerateTest {

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void test() {
        Context ctx = new Context();
        ctx.setVariable("spittleLogo", "cid:spittleLogo");
        ctx.setVariable("spitterName", "coffie");
        ctx.setVariable("spittleText", "Hiya!");
        String renderedStr = templateEngine.process("mailtemplate.html", ctx);
        System.out.println(renderedStr);
    }
}
