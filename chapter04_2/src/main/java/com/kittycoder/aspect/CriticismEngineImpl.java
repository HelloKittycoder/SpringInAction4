package com.kittycoder.aspect;

/**
 * Created by shucheng on 2020/7/2 7:37
 */
public class CriticismEngineImpl implements CriticismEngine {
    public CriticismEngineImpl() {
    }

    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    // injected
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
