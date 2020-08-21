package com.kittycoder.springjms;

import com.kittycoder.alert.AlertService;
import com.kittycoder.domain.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by shucheng on 2020/7/27 15:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/messaging.xml")
public class SpittleJmsMain {

    @Autowired
    private AlertService alertService;

    // 异步发送消息
    @Test
    public void sendMessage() {
        Spittle spittle = new Spittle(1L, null, "Hello", new Date());
        alertService.sendSpittleAlert(spittle);
    }

    // 同步接收消息（要测试这个的话，先把messaging.xml中的异步接收消息的监听器给注释掉，不然一发消息，
    // 马上会被监听到并处理掉）
    @Test
    public void receiveMessage() {
        // System.out.println(alertService);
        Spittle spittle = alertService.retrieveSpittleAlert();
        System.out.println(spittle);
    }
}
