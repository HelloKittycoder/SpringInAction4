package com.kittycoder.knightdemo.quest.impl;

import com.kittycoder.knightdemo.quest.Quest;

/**
 * Created by shucheng on 2020/6/25 10:34
 */
public class RescueDamselQuest implements Quest {
    @Override
    public void embark() {
        System.out.println("调用RescueDamselQuest#embark");
    }
}
