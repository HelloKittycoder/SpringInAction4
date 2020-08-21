package com.kittycoder.config;

import com.kittycoder.concert.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by shucheng on 2020/6/28 17:47
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.kittycoder.concert")
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }
}
