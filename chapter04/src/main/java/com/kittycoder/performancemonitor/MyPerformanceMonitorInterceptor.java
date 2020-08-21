package com.kittycoder.performancemonitor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

import java.util.Date;

/**
 * Created by shucheng on 2020/8/6 22:32
 */
public class MyPerformanceMonitorInterceptor extends AbstractMonitoringInterceptor {

    public MyPerformanceMonitorInterceptor() {
    }

    public MyPerformanceMonitorInterceptor(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected boolean isLogEnabled(Log logger) {
        return logger.isInfoEnabled();
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {

        String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        logger.info("Method " + name + " execution started at:" + new Date());
        try {
            return invocation.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            logger.info("Method " + name + " execution lasted:" + time + "ms");
            logger.info("Method " + name + " execution ended at:" + new Date());

            if (time > 10) {
                logger.warn("Method execution longer than 10ms!");
            }
        }
    }
}
