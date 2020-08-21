package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

/**
 * Created by shucheng on 2020/7/2 20:49
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
        return new Class<?>[] {WebConfig.class};
    }

    // ContextLoaderListener
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }
}
