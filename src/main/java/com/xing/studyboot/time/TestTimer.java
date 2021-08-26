package com.xing.studyboot.time;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  util包的定时，支持
 * @author xing
 * @createTime
 */
public class TestTimer {

	public static void main(String[] args) {
		//一、JDK自带的timer java.util.Timer类，这个类允许你调度一个java.util.TimerTask任务。使用这种方式可以让你的程序按照某一个频度执行，但不能在指定时间运行。一般用的较少。
		//新建一个任务操作
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				System.out.println("执行。。。"+LocalDateTime.now());
			}
		};
		Timer timer = new Timer();
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里10毫秒后开始执行，每3秒执行一次
        timer.schedule(timerTask,10,3000);
        
        //二、ScheduledExecutorService：也jdk自带的一个类；是基于线程池设计的定时任务类,每个调度任务都会分配到线程池中的一个线程去执行,也就是说,任务是并发执行,互不影响。
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 参数：1、任务体 2、首次执行的延时时间 3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(()->System.out.println("task ScheduledExecutorService "+new Date()), 0, 3, TimeUnit.SECONDS);

	}
}
