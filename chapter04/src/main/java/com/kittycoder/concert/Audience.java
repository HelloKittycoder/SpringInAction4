package com.kittycoder.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by shucheng on 2020/6/28 17:47
 */
@Aspect
public class Audience {

    // 写法一（普通通知）：
    /*@Before("execution(** com.kittycoder.concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("execution(** com.kittycoder.concert.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking Seats");
    }

    @AfterReturning("execution(** com.kittycoder.concert.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(** com.kittycoder.concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }*/

    // 写法二：（普通通知）：
    /*@Pointcut("execution(** com.kittycoder.concert.Performance.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking Seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }*/

    // 写法三：（环绕通知）：
    @Pointcut("execution(** com.kittycoder.concert.Performance.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking Seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
