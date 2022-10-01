package com.kittycoder.publisher.impl;

import com.kittycoder.publisher.SpittleNotifier;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

import javax.management.Notification;

/**
 * @author shucheng
 * @date 2022/10/1 20:42
 */
@Component
@ManagedResource("spitter:name=SpitterNotifier")
@ManagedNotification(notificationTypes = "SpittleNotifier.OneMillionSpittles",
    name = "TODO")
public class SpittleNotifierImpl implements NotificationPublisherAware, SpittleNotifier {

    private NotificationPublisher notificationPublisher;

    // 实现NotificationPublisherAware接口，注入notificationPublisher
    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }

    @Override
    public void millionthSpittlePosted() {
        // 发送通知
        notificationPublisher.sendNotification(
                new Notification("SpittleNotifier.OneMillionSpittles", this, 0));
        System.out.println("通知发送成功...");
    }
}
