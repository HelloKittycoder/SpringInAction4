package com.kittycoder.knightdemo.config;

import com.kittycoder.knightdemo.knight.Knight;
import com.kittycoder.knightdemo.knight.impl.BraveKnight;
import com.kittycoder.knightdemo.quest.Quest;
import com.kittycoder.knightdemo.quest.impl.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2020/6/25 14:50
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
