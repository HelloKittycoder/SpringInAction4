package com.kittycoder.soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shucheng on 2020/7/1 17:21
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* com.kittycoder.soundsystem.CompactDisc.playTrack(int))" +
            "&&args(trackNumber)")
    public void trackPlayed(int trackNumber) {}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ?
                trackCounts.get(trackNumber) : 0;
    }
}
