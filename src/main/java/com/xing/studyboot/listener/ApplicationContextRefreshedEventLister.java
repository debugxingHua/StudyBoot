package com.xing.studyboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * ContextRefreshedEvent 监听器
 * @author xing
 * @createTime
 */
@Component
public class ApplicationContextRefreshedEventLister implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("ApplicationContextRefreshedEventLister->"+event);
	}

}
