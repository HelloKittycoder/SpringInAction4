package com.kittycoder.aspect;

/**
 * Created by shucheng on 2020/7/2 7:30
 */
public aspect CriticAspect {
    public CriticAspect() {
    }

    pointcut performance() : execution(* com.kittycoder.concert.Performance.perform(..));

    // TODO：下面的代码尝试用ajc编译，但始终报语法错误
    /*afterReturning() : performance() {
        // System.out.println(criticismEngine.getCriticism());
        System.out.println("111");
    }*/

    /*private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }*/
}
