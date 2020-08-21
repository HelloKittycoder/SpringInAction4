package com.kittycoder.performancemonitor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by shucheng on 2020/8/5 22:56
 * 参考tutorials（https://github.com/HelloKittycoder/tutorials）中spring-aop的写法
 */
public class PerformanceAppTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
        Person person = (Person) context.getBean("person");
        PersonService personService = (PersonService) context.getBean("personService");

        System.out.println("Name is:" + personService.getFullName(person));
        System.out.println("Age is:" + personService.getAge(person));
    }
}
