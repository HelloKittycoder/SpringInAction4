package com.kittycoder.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by shucheng on 2020/7/28 21:26
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // DispatcherServlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class, WebSocketConfig.class };
    }

    // ContextLoaderListener
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {};
    }
}
