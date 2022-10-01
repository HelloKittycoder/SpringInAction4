package com.kittycoder.listener;

import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * @author shucheng
 * @date 2022/10/1 20:49
 */
@Component
// 下面这行如果不加的话，根本启动不了
@ManagedResource(objectName="spitter:name=PagingNotificationListener")
public class PagingNotificationListener implements NotificationListener {

    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println("收到通知了");
    }
}
