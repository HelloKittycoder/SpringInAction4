package com.kittycoder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by shucheng on 2020/7/30 9:45
 */
@Configuration
@ComponentScan("com.kittycoder")
@PropertySource("classpath:mail.properties")
public class MailConfig {

    /**
     * 配置这个是为了在运行时注入properties中的值
     * SpitterMailServiceImpl中用到了
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JavaMailSender mailSender(Environment env) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // 邮件服务器主机名
        mailSender.setHost(env.getProperty("mailserver.host"));
        // 邮件服务器监听的端口号
        mailSender.setPort(Integer.parseInt(env.getProperty("mailserver.port")));
        // 用户名称
        mailSender.setUsername(env.getProperty("mailserver.username"));
        // 密码
        mailSender.setPassword(env.getProperty("mailserver.password"));
        // ssl加密，需要加，否则无法运行
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}
