package com.kittycoder.external;

import com.kittycoder.external.properties.PropertiesJavaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by shucheng on 2020/6/27 13:11
 */
public class EnvironmentInjectionTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = EnvironmentConfig.class)
    public static class InjectFromProperties {
        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            System.out.println(blankDisc);
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = EnvironmentConfigWithDefaults.class)
    public static class InjectFromPropertiesWithDefaultValues {
        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            System.out.println(blankDisc);
        }
    }

    public static class InjectFromPropertiesWithRequiredProperties {

        @Test(expected = BeanCreationException.class)
        public void assertBlankDiscProperties() {
            new AnnotationConfigApplicationContext(EnvironmentConfigWithRequiredProperties.class);
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:com/kittycoder/external/placeholder-config.xml")
    public static class InjectFromProperties_XMLConfig {
        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            System.out.println(blankDisc);
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = PropertiesJavaConfig.class)
    public static class InjectFromProperties_JavaConfig {

        @Autowired
        private ApplicationContext ctx;
        /*@Autowired
        private BlankDisc blankDisc;*/

        @Test
        public void assertBlankDiscProperties() {
            Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(ctx.getBean(com.kittycoder.external.properties.BlankDisc.class));
            // System.out.println(blankDisc);
        }
    }
}
