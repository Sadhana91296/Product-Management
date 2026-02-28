package com.ecommerce.project.rabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static  void Main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();

        DeliverCallback deliverCallback=(Consumer,deliverCallback1)->{
            String message=new String(deliverCallback1.getBody());
            System.out.println("Message Received ="+message);
        };
        channel.basicConsume("Queue-1",true,deliverCallback,Consumer->{});
    }
}
