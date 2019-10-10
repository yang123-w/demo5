package com.example.test;
import com.example.Util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class TxRecv {

    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = ConnectionUtil.getConnection();

        // 打开通道
        Channel channel = connection.createChannel();

        // 申明要消费的队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消费消息
        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 接收到的消息
                String message = new String(body);
                System.out.println(" [x] Received '" + message + "'");
            }
        });

    }

}
