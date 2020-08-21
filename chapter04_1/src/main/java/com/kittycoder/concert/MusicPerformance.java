package com.kittycoder.concert;

import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/6/28 17:47
 */
@Component
public class MusicPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("=======MusicPerformance#perform=======");
        // System.out.println(1/0);
    }
}
