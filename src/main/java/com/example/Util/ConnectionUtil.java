package com.example.Util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 获取RabbitMQ Connection连接
 */
public class ConnectionUtil {

    private static final String host = "127.0.0.1";
    private static final int port = 5672;

    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        return connectionFactory.newConnection();

    }
}
