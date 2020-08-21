package com.kittycoder;

import com.kittycoder.config.RmiClientConfig;
import com.kittycoder.service.SpitterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shucheng on 2020/7/22 13:17
 */
public class SpringRmiClientTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(RmiClientConfig.class);
        ctx.refresh();

        SpitterService spitterService = (SpitterService) ctx.getBean("spitterService");
        System.out.println(spitterService.sayHello());
    }
}
