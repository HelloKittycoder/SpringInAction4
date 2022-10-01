package com.kittycoder.controller;

import com.kittycoder.listener.PagingNotificationListener;
import com.kittycoder.publisher.SpittleNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shucheng
 * @date 2022/10/1 21:59
 */
@Controller
public class SpittleController {

    @Autowired
    private SpittleNotifier spittleNotifier;

    @Autowired
    private MBeanExporter mBeanExporter;

    @RequestMapping("/sendNotice")
    @ResponseBody
    public String sendNotice() {
        spittleNotifier.millionthSpittlePosted();
        System.out.println(mBeanExporter);
        return "success";
    }
}
