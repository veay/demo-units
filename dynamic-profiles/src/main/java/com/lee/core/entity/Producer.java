package com.lee.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
/**
 * Created by jackl on 2017.8.5.
 */
@Service
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

 
}