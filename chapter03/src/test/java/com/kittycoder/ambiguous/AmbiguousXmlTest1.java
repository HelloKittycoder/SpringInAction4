package com.kittycoder.ambiguous;

import com.kittycoder.ambiguous.m1.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by shucheng on 2020/6/27 9:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/kittycoder/ambiguous/ambiguous-test01.xml")
public class AmbiguousXmlTest1 {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test() {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        People people = context.getBean(People.class);
        System.out.println(people);
    }
}
