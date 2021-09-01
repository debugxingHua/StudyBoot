package com.xing.studyboot.rest.controller;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xing.studyboot.rest.service.CommonService;

/**
 *  第一个测试服务
 * @author xing
 *
 */
@RestController
@RequestMapping("/rest")
public class FristController {
	
	@Autowired
	private CommonService commonService;
	@Autowired
	Endpoint endpoint;
	
	/**
	 * index
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		commonService.index();
		return "hello123456,frist Controller index";
	}
	
	@RequestMapping("/getName")
	public String getName() {
		return "获取到application中配置的:myname is->"+commonService.getMyName();
	}
	
	@RequestMapping("/endpoint")
	public String testEndpoint() {
		return endpoint.toString();
	}
	
	
}
