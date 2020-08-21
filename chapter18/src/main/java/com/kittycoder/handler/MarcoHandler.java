package com.kittycoder.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Created by shucheng on 2020/7/28 21:12
 */
public class MarcoHandler extends AbstractWebSocketHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received message: " + message.getPayload());
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("Polo!"));
    }
}
