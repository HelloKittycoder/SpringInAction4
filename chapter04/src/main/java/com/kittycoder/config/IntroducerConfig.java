package com.kittycoder.config;

import com.kittycoder.concert.MusicPerformance;
import com.kittycoder.concert.Performance;
import com.kittycoder.introducer.DefaultEncoreableImpl;
import com.kittycoder.introducer.Encoreable;
import com.kittycoder.introducer.EncoreableIntroducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by shucheng on 2020/7/1 17:54
 */
@Configuration
@EnableAspectJAutoProxy
public class IntroducerConfig {

    @Bean
    public EncoreableIntroducer introducer() {
        return new EncoreableIntroducer();
    }

    @Bean
    public Performance musicPerformance() {
        return new MusicPerformance();
    }

    @Bean
    public Encoreable encoreable() {
        return new DefaultEncoreableImpl();
    }
}
