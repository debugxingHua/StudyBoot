package com.xing.studyboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xing.studyboot.message.Producer;

/**
 *  消息测试服务
 * @author xing
 *
 */
@RestController
@RequestMapping("/msg")
public class MessageController {
	
	@Autowired
	private Producer producer;
	
	@RequestMapping("/sendMessage/{msg}")
	public String testEndpoint(@PathVariable String msg) {
		producer.sendMessage("qqq", msg);
		return "消息【  "+msg+" 】发送成功";
	}
}
