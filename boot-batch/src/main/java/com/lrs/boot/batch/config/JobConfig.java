package com.lrs.boot.batch.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	protected Tasklet tasklet() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

				System.out.println(
						"====================================任务执行======================================");

				return RepeatStatus.FINISHED;
			}
		};
	}

	@Bean
	public Job job(Step step) {
		return jobBuilderFactory.get("job")
				.start(step)
				.build();
	}

	@Bean
	public Step step(Tasklet tasklet) {
		return stepBuilderFactory.get("step")
				.listener(stepExecutionListener())
				.tasklet(tasklet)
				.build();
	}

	protected StepExecutionListener stepExecutionListener() {
		return new StepExecutionListener() {

			@Override
			public void beforeStep(StepExecution stepExecution) {
				System.out.println("========================= 任务执行前 ========================");

			}

			@Override
			public ExitStatus afterStep(StepExecution stepExecution) {
				System.out.println("========================= 任务执行后 ========================");
				return ExitStatus.COMPLETED;
			}
		};
	}

}
