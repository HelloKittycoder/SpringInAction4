package com.kittycoder.soundsystem;

import com.kittycoder.config.TrackCounterConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by shucheng on 2020/7/1 17:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private TrackCounter counter;

    @Test
    public void trackPlayed() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(2);

        assertEquals(1, counter.getPlayCount(1));
        assertEquals(3, counter.getPlayCount(2));
    }
}
