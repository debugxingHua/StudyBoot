package com.xing.studyboot.listener.server;

import javax.annotation.PreDestroy;

public class ShutdownPreDestroy {
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("哈喽 ShutdownPreDestroy is destroyed");
	}
}
