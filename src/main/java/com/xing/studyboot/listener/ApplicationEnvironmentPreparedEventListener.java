package com.xing.studyboot.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationEnvironmentPreparedEvent 监听器 
 * @author xing
 * @createTime
 */
@Component
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		System.out.println("ApplicationEnvironmentPreparedEventListener->"+event);
	}

}
