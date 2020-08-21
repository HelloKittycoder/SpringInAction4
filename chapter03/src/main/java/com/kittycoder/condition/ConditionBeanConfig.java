package com.kittycoder.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2020/6/26 22:17
 */
@Configuration
public class ConditionBeanConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean("magic");
    }
}
