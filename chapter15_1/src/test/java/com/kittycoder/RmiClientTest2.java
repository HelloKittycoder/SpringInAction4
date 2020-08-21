package com.kittycoder;

import com.kittycoder.config.RmiClientConfig;
import com.kittycoder.service.SpitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shucheng on 2020/7/22 13:17
 * 使用单元测试来调用方法（自动注入bean）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RmiClientConfig.class)
public class RmiClientTest2 {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void hello() {
        System.out.println(spitterService.sayHello());
    }
}
