package com.kittycoder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2020/7/27 23:16
 */
public class SpringJmsRmiServerTest {

    public static void main(String[] args) {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/messaging-server.xml");
        new ClassPathXmlApplicationContext("classpath:META-INF/spring/messaging-server.xml");
        System.out.println("服务发布成功");
    }
}
