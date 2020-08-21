package com.kittycoder;

import com.kittycoder.soundsystem.CDPlayerConfig;
import com.kittycoder.soundsystem.CompactDisc;
import com.kittycoder.soundsystem.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by shucheng on 2020/6/25 19:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private ApplicationContext context;

    @Autowired
    @Qualifier(value = "cdPlayer")
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        // CompactDisc bean = context.getBean(CompactDisc.class);
        // System.out.println(bean);
        // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        player.play();
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
