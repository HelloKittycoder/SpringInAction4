package com.kittycoder.pointcutadvice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by shucheng on 2020/8/7 9:53
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.kittycoder.pointcutadvice")
public class AopConfiguration {
}
