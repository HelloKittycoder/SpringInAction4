package spittr.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

import javax.servlet.Filter;

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

    /**
     * 采用java配置的方式添加编码过滤器
     * https://www.iteye.com/blog/hanqunfeng-2114967
     * https://blog.csdn.net/kalision/article/details/46441081/
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }
}
