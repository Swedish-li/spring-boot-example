package com.lrs.boot.batch;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.rule.OutputCapture;

public class JobAppTest {
	// 捕获控制台输出(System.out, System.err.)
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() {
		// 启动完成后退出
		assertThat(SpringApplication.exit(SpringApplication.run(JobApp.class)))
				.isEqualTo(0);
		String output = outputCapture.toString();

		assertThat(output)
				.contains("任务执行前")
				.contains("任务执行")
				.contains("任务执行后")
				.contains("completed with the following parameters");

	}

}
