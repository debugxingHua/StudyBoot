package com.xing.studyboot.event;

import org.springframework.context.ApplicationEvent;

import com.xing.studyboot.entity.dto.BusinessLogDto;

import lombok.Getter;

/**
 *  业务日志事件
 * @author xing
 *
 */
@Getter
public class BusinessLogEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	private BusinessLogDto businessLogDto;

	public BusinessLogEvent(Object source, BusinessLogDto businessLogDto) {
		super(source);
		this.businessLogDto = businessLogDto;
	}

}
