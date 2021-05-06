package com.xing.studyboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.servlet.ApplicationContextRequestMatcher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.xing.studyboot.config.MyBanner;
import com.xing.studyboot.listener.ApplicationContextRefreshedEventLister;
import com.xing.studyboot.listener.ApplicationStartedEventListener;
import com.xing.studyboot.listener.MyListener;

@SpringBootApplication
public class StudybootApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(StudybootApplication.class);
		springApplication.setBanner(new MyBanner());//设置启动banner
		// 添加启动时事件监听器 建议采用 @Component注解实现
//		springApplication.addListeners(
//				new ApplicationStartedEventListener(),
//				new ApplicationContextRefreshedEventLister()
//			);
		springApplication.run(args);
	}

}
