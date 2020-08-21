package com.kittycoder.soundsystem.config3;

import com.kittycoder.soundsystem.CDPlayer;
import com.kittycoder.soundsystem.CompactDisc;
import com.kittycoder.soundsystem.MediaPlayer;
import com.kittycoder.soundsystem.config2.CDConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by shucheng on 2020/6/26 17:33
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public MediaPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
