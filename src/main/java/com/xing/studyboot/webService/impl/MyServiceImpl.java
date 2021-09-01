package com.xing.studyboot.webService.impl;

import javax.jws.WebService;
import com.xing.studyboot.webService.MyService;

@WebService
public class MyServiceImpl implements MyService{

	@Override
	public String hello() {
		System.out.println("hello,world");
		return "ok,hello";
	}
}
