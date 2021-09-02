package com.xing.studyboot.config.webService;

import javax.xml.ws.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sun.xml.internal.ws.transport.http.server.EndpointImpl;
import com.xing.studyboot.webService.MyService;
import com.xing.studyboot.webService.impl.MyServiceImpl;

@Configuration
public class WebServiceConfig {
	/**
	 * 创建webSocket的 Endpoint
	 * @return
	 */
//	@Bean
//	public Endpoint getEndpoint() {				
//		MyService serviceImpl=new MyServiceImpl();
//		Endpoint publish = EndpointImpl.publish("http://localhost:8099/hello",serviceImpl);
//		System.out.println("发布服务成功...");
//		return publish;
//	}
}

