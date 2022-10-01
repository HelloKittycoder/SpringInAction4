package com.kittycoder;

import com.kittycoder.config.MBeanProxyClientConfig;
import com.kittycoder.config.SpittleControllerManagedOperations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author shucheng
 * @date 2022/10/1 19:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MBeanProxyClientConfig.class)
public class MBeanProxyClientTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SpittleControllerManagedOperations spittleController;

    @Test
    public void test2() {
        // 不要打印spittleController，打印的话会报NPE异常
        // System.out.println(spittleController);
        // 通过代理设置属性
        spittleController.setSpittersPerPage(50);
        // 通过代理获取属性
        int spittersPerPage = spittleController.getSpittersPerPage();
        System.out.println(spittersPerPage);
    }
}
