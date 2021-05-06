package com.xing.studyboot.listener;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.xing.studyboot.entity.dto.BusinessLogDto;
import com.xing.studyboot.event.BusinessLogEvent;

/**
 *  使用注解的形式注册监听器
 * @author xing
 * @createTime
 */
@Component
@Order(2)
public class BusinessLogAnnotationListener {
	
	/**
     * 注册监听实现方法
     * @param businessLogEvent 业务处理推送事件
     */
    @EventListener
    @Async
    public void register(BusinessLogEvent businessLogEvent) {
        // 获取业务处理日志对象
        BusinessLogDto businessLogDto = businessLogEvent.getBusinessLogDto();
        System.out.println("BusinessLogAnnotationListener接收到的监听数据是->"+businessLogDto);
    }

}
