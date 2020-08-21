package com.kittycoder.knightdemo;

import com.kittycoder.knightdemo.knight.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2020/6/25 13:56
 */
public class KnightMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
