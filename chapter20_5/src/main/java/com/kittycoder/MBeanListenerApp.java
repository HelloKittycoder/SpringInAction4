package com.kittycoder;

import com.kittycoder.config.MBeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author shucheng
 * @date 2022/10/1 20:37
 */
public class MBeanListenerApp {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MBeanConfig.class);
        ctx.start();
        System.in.read();
        ctx.close();
    }
}
