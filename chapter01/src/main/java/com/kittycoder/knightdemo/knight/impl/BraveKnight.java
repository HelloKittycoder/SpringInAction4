package com.kittycoder.knightdemo.knight.impl;

import com.kittycoder.knightdemo.knight.Knight;
import com.kittycoder.knightdemo.quest.Quest;

/**
 * Created by shucheng on 2020/6/25 10:31
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
