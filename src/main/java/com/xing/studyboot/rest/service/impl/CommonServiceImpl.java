package com.xing.studyboot.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.xing.studyboot.entity.dto.BusinessLogDto;
import com.xing.studyboot.event.BusinessLogEvent;
import com.xing.studyboot.rest.dao.CommonDao;
import com.xing.studyboot.rest.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	CommonDao commonDao;
	
	@Value(value="${my.name}")
	private String myName;

	@Override
	public String index() {
		BusinessLogDto dto = new BusinessLogDto();
		dto.setType("0");
		dto.setResult("ok");
		dto.setParams("params");
		dto.setBusinessTime(20L);
		dto.setReceiver("xinghua");
		System.out.println("CommonServiceImpl->记录操作日志，发布事件到应用");
		applicationContext.publishEvent(new BusinessLogEvent(this, dto));
		return "CommonServiceImpl.index";
	}

	@Override
	public String getMyName() {
		System.out.println("获取到application中配置的:myname="+myName);
		return myName;
	}

	@Cacheable("sampleCacheTest")
	@Override
	public String getCache() {
		System.out.println("调用getCache开始");
		String res = commonDao.get();
		System.out.println("调用getCache结束"+res);
		return res;
	}
}
