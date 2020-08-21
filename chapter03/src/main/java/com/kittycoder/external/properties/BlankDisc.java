package com.kittycoder.external.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/6/27 12:46
 */
@Component
public class BlankDisc {

    @Value("${disc.title}")
    private String title;
    @Value("${disc.artist}")
    private String artist;

    public BlankDisc() {
    }

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "BlankDisc{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
