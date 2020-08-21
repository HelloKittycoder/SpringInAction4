package com.kittycoder.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2020/6/25 19:00
 */
@Configuration
// @ComponentScan(basePackages = {"com.kittycoder.soundsystem"})
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCompactDisc(compactDisc);
        return cdPlayer;
    }

    @Bean
    public MediaPlayer anotherCdPlayer() {
        return new CDPlayer(sgtPeppers());
    }
}
