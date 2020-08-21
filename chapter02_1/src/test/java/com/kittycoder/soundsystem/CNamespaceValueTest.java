package com.kittycoder.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shucheng on 2020/6/26 12:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CNamespaceValueTest {

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void test() {
        mediaPlayer.play();
    }
}
