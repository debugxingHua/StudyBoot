package com.xing.studyboot;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shutdown")
public class StudyShutdownApplication {
	
	/**
	 *  index
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "shutdown";
	}

	/**
	 *  exit
	 * @return
	 */
//	@RequestMapping("/exit")
//	public String exit() {
//		ConfigurableApplicationContext ctx = SpringApplication.run(StudyShutdownApplication.class, args);
//
//		try {
//		TimeUnit.SECONDS.sleep(10);
//
//		} catch (InterruptedException e) {
//		e.printStackTrace();
//
//		}
//
//		ctx.close();
//		return "shutdown";
//	}
}
