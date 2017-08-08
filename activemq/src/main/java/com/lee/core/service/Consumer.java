package com.lee.core.service;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.*;

/**
 * Created by jack on 2017/8/8.
 */
@Component
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    ConnectionFactory connectionFactory = null;

    Connection connection;
    // Session： 一个发送或接收消息的线程
    Session session;

    Destination destination;

    //交易消息接收者
    MessageConsumer consumer;


    @Value("${activemq.user}")
    private String mqUserName;

    @Value("${activemq.password}")
    private String mqPassword;

    @Value("${activemq.broker-url}")
    private String mqUrl;

    @Value("${activemq.subject}")
    private String subject;

    @PostConstruct
    public void init(){
        try {
            //初始化连接
            initConnection();
            //初始化session
            initSession();
            //初始化消费者
            initConsumer();

        } catch (JMSException e) {
            logger.error("",e);
        }
    }
    //初始化连接
    private void initConnection() throws JMSException {
        if (StringUtils.isEmpty(mqUserName) || StringUtils.isEmpty(mqPassword)) {
            connectionFactory = new ActiveMQConnectionFactory( ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, mqUrl);
        }else{
            connectionFactory = new ActiveMQConnectionFactory(mqUserName,mqPassword, mqUrl);
        }
        connection = connectionFactory.createConnection();
        // 启动
        connection.start();

    }
    //初始化session
    private void initSession() throws JMSException {
        session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
    }

    //初始化消费者
    private void initConsumer() throws JMSException {
        destination = session.createQueue(subject);
        consumer = session.createConsumer(destination);
    }

    /**
     * 接收
     * @throws JMSException
     */
    public Message getMessage() throws JMSException {
        Message message = consumer.receive(1);
        if (null!=message){
            session.commit();
        }
        return message;
    }
}
