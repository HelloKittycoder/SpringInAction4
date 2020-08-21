package com.kittycoder.performancemonitor;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by shucheng on 2020/8/5 21:14
 */
@Configuration
@EnableAspectJAutoProxy // 如果只是通过Spring来启动的话，需要加上这个注解
public class AopConfiguration {

    @Pointcut("execution(public String com.kittycoder.performancemonitor.PersonService.getFullName(..))")
    public void monitor() { }

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.kittycoder.performancemonitor.AopConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }

    @Bean
    public Person person() {
        return new Person("John", "Smith", LocalDate.of(1980, Month.JANUARY, 12));
    }

    @Bean
    public PersonService personService() {
        return new PersonService();
    }


    @Pointcut("execution(public int com.kittycoder.performancemonitor.PersonService.getAge(..))")
    public void myMonitor() { }

    @Bean
    public MyPerformanceMonitorInterceptor myPerformanceMonitorInterceptor() {
        return new MyPerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor myPerformanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.kittycoder.performancemonitor.AopConfiguration.myMonitor()");
        return new DefaultPointcutAdvisor(pointcut, myPerformanceMonitorInterceptor());
    }
}
