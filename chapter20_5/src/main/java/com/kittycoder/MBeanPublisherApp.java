package com.kittycoder;

import com.kittycoder.config.MBeanConfig;
import com.kittycoder.publisher.SpittleNotifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author shucheng
 * @date 2022/10/1 20:36
 */
public class MBeanPublisherApp {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MBeanConfig.class);
        ctx.start();
        System.in.read();
        SpittleNotifier spittleNotifier = ctx.getBean(SpittleNotifier.class);
        spittleNotifier.millionthSpittlePosted();
        System.in.read();
        ctx.close();
    }
}
