package com.kittycoder.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by shucheng on 2020/6/26 18:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/kittycoder/soundsystem/xml3/soundsystem-config3.xml"})
public class XmlConfig3Test {

    @Autowired
    private MediaPlayer player;

    @Test
    public void testPlay() {
        player.play();
    }
}
