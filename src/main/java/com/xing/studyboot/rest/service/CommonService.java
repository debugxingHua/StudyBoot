package com.xing.studyboot.rest.service;

/**
 *  公共业务接口
 * @author xing
 *
 */
public interface CommonService {
	
	/**
	 *  index
	 * @return
	 */
	String index();
	
	/**
	 *  获取application中配置的名字
	 * @return
	 */
	String getMyName();
	
	/**
	 *  缓存测试
	 * @return
	 */
	String getCache();

}
