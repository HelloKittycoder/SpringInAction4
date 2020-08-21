package com.kittycoder.soundsystem.collections;

import com.kittycoder.soundsystem.CompactDisc;

import java.util.List;

/**
 * Created by shucheng on 2020/6/26 12:49
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;
    private List<CompactDisc> list;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public BlankDisc(String title, String artist, List<String> tracks, List<CompactDisc> list) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
        this.list = list;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }
}
