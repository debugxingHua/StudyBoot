package com.xing.studyboot.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer{

	@JmsListener(destination = "qqq")    //queue名
	public void receiveQueue(String txt) {
	    System.out.println("监听到【qqq】队列的消息:" + txt);
	}
}
