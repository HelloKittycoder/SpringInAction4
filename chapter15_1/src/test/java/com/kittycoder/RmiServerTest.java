package com.kittycoder;

import com.kittycoder.config.RmiServerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring整合RMI
 * 参考链接：https://www.iteye.com/blog/langgufu-2183267
 *
 * Created by shucheng on 2020/7/22 13:09
 * 这里不能写单元测试，写的话，没办法阻塞
 */
public class RmiServerTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(RmiServerConfig.class);
        ctx.refresh();
    }
}
