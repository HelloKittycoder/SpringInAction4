package com.kittycoder;

import com.kittycoder.config.TestBeanConfig;
import com.kittycoder.controller.SpittleController;
import com.kittycoder.po.Spittle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.jsp.JspPage;
import java.util.List;

/**
 * Created by shucheng on 2020/7/25 23:24
 * 如何给完全使用注解配置的springmvc项目写单元测试？
 * 参考链接：https://www.devglan.com/spring-mvc/writing-junit-tests-in-spring4-mvc
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestBeanConfig.class)
public class RestTemplateTest {

    @Autowired
    private SpittleController spittleController;
    @Autowired
    private WebApplicationContext webApplicationContext;
    // protected MockMvc mockMvc;
    @Autowired
    private RestTemplate rest;

    @Before
    public void setup(){
        System.out.println("setup=====" + spittleController);
        //加载web容器上下文
        // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() {
        /*System.out.println(spittleController);
        System.out.println(webApplicationContext);*/
        // List<Spittle> spittles = spittleController.spittles(1, 20);

        // getForObject无法直接返回对象List数据，只能间接返回对象数组
        // Spittle[] spittles = rest.getForObject("http://localhost:8080/spittles", Spittle[].class);
        /*Object[] spittles = rest.getForObject("http://localhost:8080/spittles", Object[].class);
        System.out.println(spittles);*/

        // 如果要返回对象List数据，要使用exchange
        // new ParameterizedTypeReference<List<Spittle>>(){}
        // 参考链接：https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
        ResponseEntity<List<Spittle>> spittles = rest.exchange("http://localhost:8080/spittles", HttpMethod.GET, null, new ParameterizedTypeReference<List<Spittle>>() {
        });
        List<Spittle> body = spittles.getBody();
        System.out.println(body);
    }
}
