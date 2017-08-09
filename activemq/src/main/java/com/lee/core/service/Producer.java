package com.lee.core.service;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;

/**
 * Created by jack on 2017/8/8.
 */
@Service
public class Producer {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    ConnectionFactory connectionFactory = null;

    Connection connection;
    // Session： 一个发送或接收消息的线程
    Session session;
    //交易消息发送者
    MessageProducer producer;


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
            //初始化生产者
            initProducer();

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

    //初始化生产者
    private void initProducer() throws JMSException {
        // 得到消息生成者
        producer = session.createProducer(session.createQueue(subject));
        // 设置持久化
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
    }


    /**
     * 发送消息
     * @param object
     * @throws JMSException
     */
    public void sendMessage(Object object) throws JMSException {
        if (object!=null){
            producer.send(session.createTextMessage(object.toString()));
            session.commit();
        }
    }

}
