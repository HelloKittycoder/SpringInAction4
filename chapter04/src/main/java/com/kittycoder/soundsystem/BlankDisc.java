package com.kittycoder.soundsystem;

import java.util.List;

/**
 * Created by shucheng on 2020/7/1 14:35
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks; // 磁道

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("正在播放第" + trackNumber + "磁道【" +
                tracks.get(trackNumber - 1) + "】...");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
