package com.xing.studyboot.entity.dto;

import lombok.Data;

@Data
public class EmailDto {
	/**
	 * 目标邮箱
	 */
	private String to;
	/**
	 * 主题
	 */
	private String subject;
	/**
	 * 内容
	 */
	private String text;
	/**
	 * 附件
	 */
	private String file;
}
