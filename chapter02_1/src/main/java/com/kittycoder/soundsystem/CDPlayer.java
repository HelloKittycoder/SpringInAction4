package com.kittycoder.soundsystem;

/**
 * Created by shucheng on 2020/6/26 12:25
 */
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
