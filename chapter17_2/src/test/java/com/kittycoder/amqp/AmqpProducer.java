package com.kittycoder.amqp;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by shucheng on 2020/7/28 12:33
 */
public class AmqpProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        String ROUTE_KEY = "rabbitmq-lsc"; // 路由键名称
        String EXCHANGE_NAME = "exchange-lsc"; // 交换器名称

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");

        // 创建连接和信道
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        // 创建一个交换器，参数为：交换器名称和交换器类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        for (int i = 0; i < 5; i++) {
            String msg = "Hello world ===> " + i;
            // 注意：rabbitmq消息类型只有一种，就是byte[]
            channel.basicPublish(EXCHANGE_NAME, ROUTE_KEY, null, msg.getBytes("UTF-8"));
            System.out.println("send:" + msg);
        }

        // 关闭信道和连接
        channel.close();
        conn.close();
    }
}
