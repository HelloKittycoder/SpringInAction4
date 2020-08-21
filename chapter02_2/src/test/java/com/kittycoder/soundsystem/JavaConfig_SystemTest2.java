package com.kittycoder.soundsystem;

import com.kittycoder.soundsystem.config2.SoundSystemConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shucheng on 2020/6/26 17:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class JavaConfig_SystemTest2 {

    @Autowired
    private MediaPlayer player;

    @Test
    public void testPlay() {
        player.play();
    }
}
