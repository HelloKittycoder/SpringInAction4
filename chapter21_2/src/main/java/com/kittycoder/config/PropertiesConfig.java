package com.kittycoder.config;

import com.kittycoder.properties.AppProperties;
import com.kittycoder.properties.AppSettings;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shucheng on 2020/8/17 17:58
 */
@Configuration
@EnableConfigurationProperties({AppProperties.class, AppSettings.class})
public class PropertiesConfig {
}
