package com.lee.core.entity;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by jackl on 2017.8.5.
 */
@Component
public class Consumer {

    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
    }
}
