package com.xing.studyboot.message;

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 *  生产者
 * @author xing
 * @createTime
 */
@Service("producer")
public class Producer {
    @Autowired
    JmsMessagingTemplate jmsTemplate;

    /**
     * 发送消息
     *
     * @param destination 发送到的队列名
     * @param message     消息体
     */
    public void sendMessage(String destination, String message) {
    	System.out.println("给队列【qqq】发送消息："+message);
        jmsTemplate.convertAndSend(destination, message);
    }
}
