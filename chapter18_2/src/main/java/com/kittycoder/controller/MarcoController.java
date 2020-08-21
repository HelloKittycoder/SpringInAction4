package com.kittycoder.controller;

import com.kittycoder.po.Shout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by shucheng on 2020/7/29 19:18
 */
@Controller
public class MarcoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @MessageMapping("/marco")
    public Shout handleShout(Shout incoming) {
        logger.info("Received message: " + incoming.getMessage());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");
        logger.info("Replied message: " + outgoing.getMessage());

        return outgoing;
    }
}
