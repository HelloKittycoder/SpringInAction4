package com.kittycoder;

import com.kittycoder.knightdemo.knight.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shucheng on 2020/6/25 17:57
 */
public class MinstrelTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/minstrel.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
    }
}
