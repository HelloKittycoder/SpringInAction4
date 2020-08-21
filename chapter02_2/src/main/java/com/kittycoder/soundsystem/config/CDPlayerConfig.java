package com.kittycoder.soundsystem.config;

import com.kittycoder.soundsystem.CDPlayer;
import com.kittycoder.soundsystem.CompactDisc;
import com.kittycoder.soundsystem.MediaPlayer;
import com.kittycoder.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2020/6/26 17:33
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public MediaPlayer cdPlayer() {
        return new CDPlayer(compactDisc());
    }

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }
}
