package com.kittycoder.soundsystem.xml2;

import com.kittycoder.soundsystem.CompactDisc;
import com.kittycoder.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2020/6/26 17:41
 */
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }
}
