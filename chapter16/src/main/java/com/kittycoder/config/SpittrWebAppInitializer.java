package com.kittycoder.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by shucheng on 2020/7/25 21:05
 * 参考chapter07_3写的
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public SpittrWebAppInitializer() {
        System.out.println("调用SpittrWebAppInitializer初始化方法");
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // DispatcherServlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    // ContextLoaderListener
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }
}
