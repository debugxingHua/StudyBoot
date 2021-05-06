package com.xing.studyboot.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *  ApplicationStartingEvent 监听器 
 * @author xing
 * @createTime
 */
@Component
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("ApplicationStartingEventListener->"+event);
	}

}
