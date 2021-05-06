package com.xing.studyboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.xing.studyboot.entity.dto.BusinessLogDto;
import com.xing.studyboot.event.BusinessLogEvent;

/**
 *  注册业务日志的监听器
 * @author xing
 * @createTime
 */
@Component
@Order(1)
public class BusinessLogListener implements ApplicationListener<BusinessLogEvent> {

	@Override
	public void onApplicationEvent(BusinessLogEvent businessLogEvent) {
        BusinessLogDto businessLogDto = businessLogEvent.getBusinessLogDto();
        System.out.println("BusinessLogListener接收到的监听数据是->"+businessLogDto);
    }

}
