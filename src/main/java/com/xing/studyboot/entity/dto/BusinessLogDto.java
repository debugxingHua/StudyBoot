package com.xing.studyboot.entity.dto;

import lombok.Data;
/**
 *  业务日志记录实体类
 * @author xing
 *
 */
@Data
public class BusinessLogDto {
	
	/**
	 * 业务类型
	 */
    private String type;
    /**
     * 业务处理时长
     */
    private long businessTime;
    /**
     * 业务处理结果
     */
    private String result;
    /**
     * 请求参数
     */
    private String params;
	/**
	 * 操作着
	 */
	public String receiver;
	
}
