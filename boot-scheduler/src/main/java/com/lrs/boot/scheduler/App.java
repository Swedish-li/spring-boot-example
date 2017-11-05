package com.lrs.boot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.ErrorHandler;

/**
 * 官方文档
 * 
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
 * 
 * @author Swedish-li
 *
 */
@EnableScheduling
@Configuration
@SpringBootApplication
public class App {

	private final static Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	// ThreadPoolTaskExecutor,<task:executor id="executor" pool-size="10"/>

	// 使用线程池执行定时任务,<task:scheduler id="scheduler" pool-size="10"/>
	@Bean
	public TaskScheduler taskScheduler() {

		ThreadPoolTaskScheduler poolTaskScheduler = new ThreadPoolTaskScheduler();
		poolTaskScheduler.setPoolSize(10);
		poolTaskScheduler.setErrorHandler(new ErrorHandler() {

			@Override
			public void handleError(Throwable t) {
				log.error("定时任务执行出错！", t);
			}
		});

		return new ThreadPoolTaskScheduler();
	}

}
