package com.kittycoder;

import com.kittycoder.alert.AlertService;
import com.kittycoder.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shucheng on 2020/7/27 23:16
 * 参考链接：https://blog.csdn.net/hhs1314520/article/details/50439545
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/messaging-client.xml")
public class SpringJmsRmiClientTest {

    @Autowired
    private AlertService alertService;

    // 下面的测试方法中调用的3个方法，都是去调用通过activemq发布的远程服务alertService中的方法
    @Test
    public void test() {
        String str = alertService.sendStr("Hello world!");
        System.out.println("===========服务端返回========" + str);

        alertService.printStr("xixixi");

        // 说明：这里进行远程传输的对象必须实现Serializable接口
        User user = alertService.findById(1);
        System.out.println(user);
    }
}
