package com.kittycoder.soundsystem.config3;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by shucheng on 2020/6/26 17:45
 */
@Configuration
@Import({CDPlayerConfig.class})
@ImportResource("classpath:com/kittycoder/soundsystem/cd-config.xml")
public class SoundSystemConfig {
}
