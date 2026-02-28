package com.ecommerce.project;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class SbEcomApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(SbEcomApplication.class, args);
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
