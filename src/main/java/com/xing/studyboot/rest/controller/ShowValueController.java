package com.xing.studyboot.rest.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  查看配置
 * @author xing
 * @createTime
 */
@RestController
public class ShowValueController {
	
	@Autowired
	private DataSource dataSource;
	
//	@Value(value="${local.server.port}")
//	private String localServerPort;
//	
//	@Value(value="${spring.application.admin.enabled}")
//	private String springApplicationAdminEnabled;

	@Value(value="${my.secret}")
	private String mySecret;
	
	@Value(value="${my.number}")
	private String myNumber;
	
	@Value(value="${my.bignumber}")
	private String myBignumber;
	
	@Value(value="${my.uuid}")
	private String myUUid;
	
	@Value(value="${my.number.less.than.ten}")
	private String myNumberLessThanTen;
	
	@Value(value="${my.number.in.range}")
	private String myNumberInRange;

	@RequestMapping(value="/showSome")
	public String index() {
		StringBuilder str = new StringBuilder();
//		str.append("本地端口local.server.port->"+localServerPort);
//		str.append("spring.application.admin.enabled->"+springApplicationAdminEnabled);
		str.append("my.secret->"+mySecret+"<br/>");
		str.append("my.number->"+myNumber+"<br/>");
		str.append("my.bignumber->"+myBignumber+"<br/>");
		str.append("my.uuid->"+myUUid+"<br/>");
		str.append("my.number.less.than.ten->"+myNumberLessThanTen+"<br/>");
		str.append("my.my.number.in.range->"+myNumberInRange+"<br/>");
		return str.toString();
		
	}
	
	@RequestMapping(value="/showDataSource")
	public String showDataSource() throws SQLException {
		StringBuilder str = new StringBuilder();
		str.append("数据源信息    ->"+dataSource+"<br/>");
		str.append("数据连接信息->"+dataSource.getConnection()+"<br/>");
		return str.toString();
	}
}
