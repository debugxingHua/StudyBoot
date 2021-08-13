package com.xing.studyboot.listener.server;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class GracefulShutdown implements ApplicationListener<ContextClosedEvent>, TomcatConnectorCustomizer {

    private volatile Connector connector;
    int shutdownTimeout = 30;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        this.connector.pause();
        Executor executor = this.connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
            threadPoolExecutor.shutdown();

            try {
                if (threadPoolExecutor.awaitTermination(shutdownTimeout, TimeUnit.SECONDS)) {
                    System.out.println("Tomcat thread pool did not shutdown gracefully within " + shutdownTimeout
                            + " seconds. Proceeding with forceful shutdown.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("线程池->优雅停机");
    }

    @Override
    public void customize(Connector connector) {
        this.connector = connector;
    }
}
