package com.xing.studyboot.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationFailedEvent 监听器
 * @author xing
 * @createTime
 */
@Component
public class ApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent>{

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		System.out.println("ApplicationFailedEventListener->"+event);
	}

}
