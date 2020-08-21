package com.kittycoder.condition;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by shucheng on 2020/6/26 22:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionBeanConfig.class)
public class ConditionBeanConfigTest {

    static {
        System.setProperty("magic", "hehe");
    }

    @Autowired
    private ApplicationContext ctx;

    @Before
    public void setUp() {
        Environment env = ctx.getEnvironment();
        System.out.println(env.getProperty("magic"));
    }

    @Test
    public void magicBean() {
        try {
            MagicBean magicBean = (MagicBean) ctx.getBean("magicBean");
            System.out.println(magicBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
