package com.xing.studyboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import com.xing.studyboot.config.MyBanner;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
	    DataSourceTransactionManagerAutoConfiguration.class,
	    JdbcTemplateAutoConfiguration.class})
public class StudybootApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(StudybootApplication.class);
		springApplication.setBanner(new MyBanner());//设置启动banner
		springApplication.setAddCommandLineProperties(false);//禁用命令行选项参数
		springApplication.setAdditionalProfiles("server","spring");//激活配置文件比如 application-server.properties
		// 添加启动时事件监听器 建议采用 @Component注解实现
//		springApplication.addListeners(
//				new ApplicationStartedEventListener(),
//				new ApplicationContextRefreshedEventLister()
//			);
		springApplication.run(args);
	}

}
