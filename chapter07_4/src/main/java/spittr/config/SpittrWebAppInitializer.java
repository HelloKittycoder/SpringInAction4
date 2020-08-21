package spittr.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.web.WebConfig;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

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

    /**
     * 设置StandardServletMultipartResolver的参数
     * 说明：D:/tmp/spittr/这个文件夹需要提前创建好
     * MultipartConfigElement构造参数说明：
     * 1：临时文件存放目录
     * 2：上传文件的最大容量（单位：字节） 2M
     * 3：整个multipart请求的最大容量（单位：字节） 4M
     * 4：在上传过程中，如果文件大小达到一个指定的最大容量（单位：字节），将会先写到临时文件中，如果没有达到该容量，则写在内存中；
     * 默认值是0，只要上传了文件，肯定会超过0，这意味这都会写到临时文件夹中
     */
    /*@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("D:/tmp/spittr/", 2097152, 4194304, 20971));
    }*/
}
