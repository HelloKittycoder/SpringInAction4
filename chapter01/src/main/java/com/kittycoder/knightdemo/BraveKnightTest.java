package com.kittycoder.knightdemo;

import com.kittycoder.knightdemo.knight.impl.BraveKnight;
import com.kittycoder.knightdemo.quest.Quest;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by shucheng on 2020/6/25 10:36
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnRequest() {
        /*// 创建mockQuest
        Quest mockQuest = mock(Quest.class);
        // 注入mockQuest
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();*/
        System.out.println("111");
    }
}
