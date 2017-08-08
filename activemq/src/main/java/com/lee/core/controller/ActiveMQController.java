package com.lee.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.lee.core.service.Consumer;
import com.lee.core.service.ConsumerTopic;
import com.lee.core.service.Producer;
import com.lee.core.service.ProducerTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


/**
 * Created by jack on 2017/8/8.
 */
@Controller
@RequestMapping("/")
public class ActiveMQController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Consumer consumer;

    @Autowired
    Producer producer;

    @Autowired
    ConsumerTopic consumerTopic;

    @Autowired
    ProducerTopic producerTopic;

    @RequestMapping("/")
    public Object index(){
        return "index";
    }

    @RequestMapping("/send")
    @ResponseBody
    public Object sendMessage(String message){
        JSONObject result = new JSONObject();
        try {
            producer.sendMessage(message);
            result.put("result",true);
            result.put("message","发送消息:"+message+"成功");
        } catch (JMSException e) {
            logger.error("",e);
            result.put("result",false);
            result.put("message","发送消息:"+message+"异常");
        }
        return result;
    }

    @RequestMapping("/sendTopic")
    @ResponseBody
    public Object sendTopicMessage(String message){
        JSONObject result = new JSONObject();
        try {
            producerTopic.sendMessage(message);
            result.put("result",true);
            result.put("message","发送消息:"+message+"成功");
        } catch (JMSException e) {
            logger.error("",e);
            result.put("result",false);
            result.put("message","发送消息:"+message+"异常");
        }
        return result;
    }

    @RequestMapping("/get")
    @ResponseBody
    public Object getMessage(){
        JSONObject result = new JSONObject();
        try {
            Message message = consumer.getMessage();
            if (message!=null){
                TextMessage text = (TextMessage) message;
                result.put("result",true);
                result.put("message","接收到消息:"+text.getText());
            }else{
                result.put("result",true);
                result.put("message","接收到消息:暂无消息");
            }
        } catch (JMSException e) {
            logger.error("",e);
            result.put("result",false);
            result.put("message","接收消息异常");
        }
        return result;
    }
    @RequestMapping("/getTopic")
    @ResponseBody
    public Object getTopicMessage(){
        JSONObject result = new JSONObject();
        try {
            Message message = consumerTopic.getMessage();
            if (message!=null){
                TextMessage text = (TextMessage) message;
                result.put("result",true);
                result.put("message","接收到消息:"+text.getText());
            }else{
                result.put("result",true);
                result.put("message","接收到消息:暂无消息");
            }
        } catch (JMSException e) {
            logger.error("",e);
            result.put("result",false);
            result.put("message","接收消息异常");
        }
        return result;
    }
}
