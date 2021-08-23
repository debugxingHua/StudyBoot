package com.xing.studyboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xing.studyboot.rest.service.CommonService;

@RestController
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	CommonService commonService;
	
	@RequestMapping("/get")
	public String getName() {
		String res = commonService.getCache();
		return "缓存-》"+res;
	}
}
