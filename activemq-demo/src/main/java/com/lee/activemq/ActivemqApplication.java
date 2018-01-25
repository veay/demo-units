package com.lee.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

@SpringBootApplication
public class ActivemqApplication {

	@Value("${spring.activemq.user}")
	private String userName;

	@Value("${spring.activemq.password}")
	private String password;

	@Value("${spring.activemq.broker-url}")
	private String url;

	@Bean
	public Queue queue(){
		return new ActiveMQQueue("local_queue");
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
//此链接信息可放入配置文件中
		return new ActiveMQConnectionFactory(userName, password, url);
	}

	@Bean
	public JmsMessagingTemplate jmsMessagingTemplate(ActiveMQConnectionFactory connectionFactory){
		return new JmsMessagingTemplate(connectionFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(ActivemqApplication.class, args);
	}
}
