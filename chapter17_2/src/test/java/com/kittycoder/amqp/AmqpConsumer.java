package com.kittycoder.amqp;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by shucheng on 2020/7/28 12:33
 * 参考链接：https://www.cnblogs.com/duanjt/p/10057330.html
 * 无法运行
 */
public class AmqpConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        String QUEUE_NAME = "queue-lsc"; // 队列名称
        String ROUTE_KEY = "rabbitmq-lsc"; // 路由键名称
        String EXCHANGE_NAME = "exchange-lsc"; // 交换器名称

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");

        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();
        // 创建一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 创建交换器
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        // 将队列和交换器通过路由键进行绑定
        channel.queueBind(EXCHANGE_NAME, EXCHANGE_NAME, ROUTE_KEY);

        // 开始消费，第二个参数表示自动确认
        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("[Receive]: " + message);
            }
        });
    }
}
