package spittr.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by shucheng on 2020/7/5 23:17
 */
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化HelloFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("==========HelloFilter前置操作==========");
        chain.doFilter(request, response);
        System.out.println("==========HelloFilter后置操作==========");
    }

    @Override
    public void destroy() {
        System.out.println("销毁HelloFilter");
    }
}
