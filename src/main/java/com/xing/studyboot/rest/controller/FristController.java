package com.xing.studyboot.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  第一个测试服务
 * @author xing
 *
 */
@RestController
@RequestMapping("/rest")
public class FristController {
	/**
	 * index
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "hello,frist Controller index";
	}
}
