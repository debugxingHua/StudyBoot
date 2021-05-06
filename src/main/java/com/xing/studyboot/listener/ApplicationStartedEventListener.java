package com.xing.studyboot.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *  ApplicationStartedEvent 监听器 
 * @author xing
 * @createTime
 */
@Component
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("ApplicationStartedEventListener->"+event);
	}

}
