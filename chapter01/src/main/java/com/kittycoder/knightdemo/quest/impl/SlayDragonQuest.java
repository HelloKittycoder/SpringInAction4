package com.kittycoder.knightdemo.quest.impl;

import com.kittycoder.knightdemo.quest.Quest;

import java.io.PrintStream;

/**
 * Created by shucheng on 2020/6/25 10:34
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        System.out.println("调用SlayDragonQuest#embark");
    }
}
