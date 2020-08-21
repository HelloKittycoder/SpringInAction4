package com.kittycoder;


import com.kittycoder.po.MailProperties;
import com.kittycoder.properties.AppProperties;
import com.kittycoder.properties.AppSettings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by shucheng on 2020/8/17 18:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    private AppProperties appProperties;
    @Autowired
    private AppSettings appSettings;

    // 将其他bean的属性注入进来
    // 如果不需要注入别的bean的属性的话，AppProperties上的@Component注解不是必须的
    // 参考链接：https://stackoverflow.com/questions/44977967/injecting-a-bean-as-a-value-to-a-property-of-another-bean
    /*@Value("#{appProperties.mail}")
    private MailProperties mailProperties;*/

    @Test
    public void testProperties() {
        System.out.println(appProperties);
        // System.out.println(mailProperties);
        System.out.println(appSettings);
    }
}
