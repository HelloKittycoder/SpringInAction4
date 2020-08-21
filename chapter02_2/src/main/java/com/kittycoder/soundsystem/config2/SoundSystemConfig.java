package com.kittycoder.soundsystem.config2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by shucheng on 2020/6/26 17:45
 */
@Configuration
@Import({CDPlayerConfig.class})
public class SoundSystemConfig {
}
