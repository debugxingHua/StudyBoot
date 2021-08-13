package com.xing.studyboot.config.server;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xing.studyboot.listener.server.GracefulShutdown;

@Configuration
public class ShutDownConfig {
	
	@Bean
	public GracefulShutdown getShutdownPreDestroyBean() {
		return new GracefulShutdown();
	}
	
//	@Bean
//    public ConfigurableServletWebServerFactory webServerFactory(GracefulShutdown gracefulShutdown) {
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.addConnectorCustomizers(gracefulShutdown);
//        System.out.println("TomcatServletWebServerFactory->优雅停机");
//        return factory;
//    }

}
