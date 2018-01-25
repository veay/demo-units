package com.lee.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @author jack
 * @since 2018/1/25
 */
@RestController
public class QueueController {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    Queue queue;

    @RequestMapping("/send")
    public Object send(String msg){
        try{
            jmsMessagingTemplate.convertAndSend(queue,msg);
            return "true";
        }catch (Exception e){
            return "false";
        }
    }
}
