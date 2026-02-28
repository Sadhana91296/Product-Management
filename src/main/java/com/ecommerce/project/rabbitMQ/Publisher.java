package com.ecommerce.project.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void Main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();
        String ms="Hi Sadhana";
       // channel.basicPublish("","Queue-1",null,"");
        channel.basicPublish("","Queue-1",null,ms.getBytes());
        channel.close();
        connection.close();
    }
}
