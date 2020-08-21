package com.kittycoder.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by shucheng on 2020/8/18 9:09
 */
@ConfigurationProperties("kittycoder.settings")
public class AppSettings {
    private String redisHost;
    private String redisPort;

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public String getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(String redisPort) {
        this.redisPort = redisPort;
    }
}
