package com.kittycoder.aspect;

import com.kittycoder.concert.MusicPerformance;
import com.kittycoder.concert.Performance;

/**
 * Created by shucheng on 2020/7/2 7:47
 */
public class TestAspect {

    public static void main(String[] args) {
        Performance performance = new MusicPerformance();
        performance.perform();
    }
}
