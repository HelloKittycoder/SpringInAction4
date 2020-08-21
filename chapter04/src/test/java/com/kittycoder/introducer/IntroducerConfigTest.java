package com.kittycoder.introducer;

import com.kittycoder.concert.Performance;
import com.kittycoder.config.IntroducerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shucheng on 2020/7/1 17:57
 * 使用aop在已有接口上添加新方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IntroducerConfig.class)
public class IntroducerConfigTest {

    @Autowired
    private Performance performance;

    @Test
    public void testNewMethod() {
        System.out.println(performance);
        ((Encoreable)performance).newMethod();
    }
}
