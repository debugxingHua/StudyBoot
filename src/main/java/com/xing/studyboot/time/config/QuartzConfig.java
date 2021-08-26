package com.xing.studyboot.time.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xing.studyboot.time.quartz.Test2QuartzService;
import com.xing.studyboot.time.quartz.TestQuartzService;

/**
 * Quartz定时器配置
 * @author xing
 * @createTime
 */
//@Configuration//开启配置的 Quartz
public class QuartzConfig {
	
	/**
	 *  创建作业的实例。Job- TestQuartzService
	 * @return
	 */
	@Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(TestQuartzService.class)
        		.withIdentity("testQuartz")//如果没有设置，则将生成一个随机的、唯一的作业密钥。
        		.storeDurably()//默认值为false -此方法将该值设置为true。
        		.build();
    }
	
	/**
	 *  创建作业的实例。Job- Test2QuartzService
	 * @return test1Quartz
	 */
	@Bean
    public JobDetail teat2QuartzDetail(){
        return JobBuilder.newJob(Test2QuartzService.class)
        		.withIdentity("test2Quartz")
        		.storeDurably()
        		.build();
    }
	
	/**
	 *  创建触发器，并绑定到 作业实例-teatQuartzDetail
	 * @return
	 */
	@Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)  //设置时间周期单位秒
                .repeatForever();//指定触发器将无限期重复。
        return TriggerBuilder.newTrigger()
        		.forJob(teatQuartzDetail())//指定Job任务
                .withIdentity("testQuartz")
                .withSchedule(scheduleBuilder)//指定配置的时间
                .build();
    }
	
	/**
	 *  创建触发器，并绑定到 作业实例2-teat2QuartzDetail
	 * @return test2Quartz
	 */
	@Bean
    public Trigger test2QuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(50)
                .repeatForever();
        return TriggerBuilder.newTrigger()
        		.forJob(teat2QuartzDetail())//指定Job任务
                .withIdentity("test2Quartz")
                .withSchedule(scheduleBuilder)//指定配置的时间
                .build();
    }

}
