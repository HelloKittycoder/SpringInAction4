package com.kittycoder.sender;

import com.kittycoder.po.Shout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/7/29 21:51
 */
@Component
public class RandomNumberMessageSender {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private SimpMessagingTemplate messaging;

    @Autowired
    public RandomNumberMessageSender(SimpMessagingTemplate messaging) {
        this.messaging = messaging;
    }

    @Scheduled(fixedRate=10000)
    public void sendRandomNumber() {
        Shout random = new Shout();
        random.setMessage("Random # : " + (Math.random() * 100));
        messaging.convertAndSend("/topic/marco", random);
        logger.info("Replied message: " + random.getMessage());
    }
}
