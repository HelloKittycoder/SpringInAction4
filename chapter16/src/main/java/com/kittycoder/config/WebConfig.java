package com.kittycoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by shucheng on 2020/7/25 21:21
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.kittycoder")
public class WebConfig extends WebMvcConfigurerAdapter {

    /*@Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
        ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
        cnvr.setContentNegotiationManager(cnm);
        return cnvr;
    }

    // 设置默认内容类型为：TEXT_HTML
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }*/

    // beanNameViewResolver，spittles两者的作用下，把SpittleController#spittles方法变成了
    // 返回json数据的方法，此时SpittleController#spittles上面没有加@ResponseBody

    // 说明：这种写法和@ResponseBody的区别
    // 这种写法结果是：
    /*
    * {"spittleList":[
    *   {"id":1,"message":"hehe"},
    *   {"id":2,"message":"hehe2"}
    * ]}
    */
    // @ResponseBody返回的是：
    /*
     * [
     *   {"id":1,"message":"hehe"},
     *   {"id":2,"message":"hehe2"}
     * ]
     */
    /*@Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public View spittles() {
        return new MappingJackson2JsonView();
    }*/
}
