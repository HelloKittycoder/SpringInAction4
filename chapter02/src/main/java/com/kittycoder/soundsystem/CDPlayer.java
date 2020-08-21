package com.kittycoder.soundsystem;

/**
 * Created by shucheng on 2020/6/25 21:24
 */
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    public CDPlayer() {
    }

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    // @Autowired
    public void setCompactDisc(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
