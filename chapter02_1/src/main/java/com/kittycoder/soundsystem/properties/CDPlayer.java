package com.kittycoder.soundsystem.properties;

import com.kittycoder.soundsystem.CompactDisc;
import com.kittycoder.soundsystem.MediaPlayer;

/**
 * Created by shucheng on 2020/6/26 16:49
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
