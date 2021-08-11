package com.xing.studyboot.config.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xing.studyboot.listener.server.ShutdownPreDestroy;

@Configuration
public class ShutDownConfig {
	
	@Bean
	public ShutdownPreDestroy getShutdownPreDestroyBean() {
		return new ShutdownPreDestroy();
	}

}
