package com.kittycoder.knightdemo;

import com.kittycoder.knightdemo.config.KnightConfig;
import com.kittycoder.knightdemo.knight.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shucheng on 2020/6/25 14:52
 */
public class KnightMain2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
    }
}
