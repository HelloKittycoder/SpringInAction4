package com.kittycoder.properties;

import com.kittycoder.po.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/8/17 17:59
 */
// @Component
@ConfigurationProperties("kittycoder.app")
public class AppProperties {
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
