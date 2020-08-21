package com.kittycoder.pointcutadvice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/8/7 9:59
 *
 * 常用拦截表达式整理：
 * target部分：target不能写通配符，必须写类型的全限定名
 * @Pointcut("target(com.kittycoder.pointcutadvice.service.FooService)") 被拦截的类实现了FooService接口
 * @Pointcut("target(com.kittycoder.pointcutadvice.service.impl.FooServiceImpl)") 被拦截的类是FooServiceImpl或FooServiceImpl的子类
 *
 * within部分：
 * @Pointcut("within(com.kittycoder.pointcutadvice.dao.*)") 被拦截的类位于com.kittycoder.pointcutadvice.dao包下
 * @Pointcut("within(com.kittycoder.pointcutadvice.dao..*)") 被拦截的类位于com.kittycoder.pointcutadvice.dao包及其所有子包下
 *
 * @Pointcut("within(com.kittycoder.pointcutadvice.dao.*)||within(com.kittycoder.pointcutadvice.service..*)")
 * 被拦截的类位于com.kittycoder.pointcutadvice.dao包下，或者位于com.kittycoder.pointcutadvice.service包及其所有子包下
 */
@Aspect
@Component
public class PerformanceAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 下面标识被拦截的类实现了FooService接口
     */
    @Pointcut("target(com.kittycoder.pointcutadvice.service.FooService)")
    // @Pointcut("within(com.kittycoder.pointcutadvice.dao.*)||within(com.kittycoder.pointcutadvice.service..*)")
    public void repositoryClassMethods() {}

    @Around("repositoryClassMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object retval = pjp.proceed();
        long end = System.currentTimeMillis();
        String methodName = pjp.getSignature().getName();
        logger.info("Execution of " + methodName + " took " + (end - start) + " ms");
        return retval;
    }
}
