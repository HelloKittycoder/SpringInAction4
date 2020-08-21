package com.kittycoder.alert;

import com.kittycoder.domain.Spittle;

/**
 * Created by shucheng on 2020/7/27 18:04
 */
public class SpittleAlertHandler {

    // spring异步接收后处理消息的方法
    public void handleSpittleAlert(Spittle spittle) {
        System.out.println("SpittleAlertHandler#handleSpittleAlert=============================" + spittle);
    }
}
