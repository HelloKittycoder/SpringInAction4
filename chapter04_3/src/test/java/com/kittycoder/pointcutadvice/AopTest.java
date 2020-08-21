package com.kittycoder.pointcutadvice;

import com.kittycoder.pointcutadvice.config.AopConfiguration;
import com.kittycoder.pointcutadvice.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shucheng on 2020/8/7 9:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfiguration.class)
public class AopTest {

    @Autowired
    private FooService fooService;

    // 测试使用target写的切点表达式
    @Test
    public void testTargetPointcut() {
        fooService.queryFooById(3L);
    }
}
