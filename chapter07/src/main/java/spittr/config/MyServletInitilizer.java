package spittr.config;

import org.springframework.web.WebApplicationInitializer;
import spittr.filter.HelloFilter;
import spittr.servlet.HelloServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by shucheng on 2020/7/5 22:46
 */
public class MyServletInitilizer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        Dynamic helloServlet = servletContext.addServlet("helloServlet", HelloServlet.class);
        helloServlet.addMapping("/hello");

        FilterRegistration.Dynamic helloFilter = servletContext.addFilter("helloFilter", HelloFilter.class);
        helloFilter.addMappingForUrlPatterns(null, false, "/hello");
    }
}
