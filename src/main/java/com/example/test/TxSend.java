package com.example.test;

import com.example.Util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TxSend {
    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        try{
            channel.txSelect(); // 开启事务

            // 发送消息
            String message = "hello, tx message";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent message : '" + message + "'");

            //test rollback

            int i = 1/0;

            channel.txCommit(); // 提交事务
        }catch (Exception e){
            channel.txRollback(); // 回滚事务
            System.out.println("send message txRollback");
        }

        channel.close();
        connection.close();


    }


}
