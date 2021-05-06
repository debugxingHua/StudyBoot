package com.xing.studyboot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 *  监听器
 * @author xing
 * @createTime
 */
public class MyListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("监听到："+event.getSource());
	}
	
	

}
