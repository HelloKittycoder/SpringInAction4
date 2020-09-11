package com.kittycoder.properties;

import com.kittycoder.po.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by shucheng on 2020/8/17 17:59
 */
// @Component
@ConfigurationProperties("kittycoder.app")
public class AppProperties {

    // 不加@NestedConfigurationProperty时，spring-configuration-metadata.json默认不会自动识别嵌套属性，
    // 需要自己另外创建additional-spring-configuration-metadata.json
    @NestedConfigurationProperty
    private MailProperties mail = new MailProperties();

    public MailProperties getMail() {
        return mail;
    }

    /**
     * 因为不需要在application.properties配置文件中直接设置kittycoder.app.mail
     * 所以这里不要提供setter方法；但是上面必须实现创建一个MailProperties对象，不然spring无法创建
     */
    /*public void setMail(MailProperties mail) {
        this.mail = mail;
    }*/
}
