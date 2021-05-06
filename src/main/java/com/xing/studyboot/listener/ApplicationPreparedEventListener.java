package com.xing.studyboot.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *  ApplicationPreparedEvent 监听器 
 * @author xing
 * @createTime
 */
@Component
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		System.out.println("ApplicationPreparedEventListener->"+event);
	}

}
