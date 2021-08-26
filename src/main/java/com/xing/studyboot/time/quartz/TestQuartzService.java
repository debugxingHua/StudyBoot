package com.xing.studyboot.time.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Quartz定时任务业务类
 * @author xing
 * @createTime
 */
public class TestQuartzService extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {	
		System.out.println("quartz定时任务1 "+new Date());
	}
}
