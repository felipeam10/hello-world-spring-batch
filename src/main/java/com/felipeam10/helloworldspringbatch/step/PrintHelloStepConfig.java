package com.felipeam10.helloworldspringbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PrintHelloStepConfig {

    @Bean
    public Step printHelloStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager, Tasklet printHelloTasklet) {
        return new StepBuilder("printHelloStep", jobRepository)
                .tasklet(printHelloTasklet, platformTransactionManager)
                .build();
    }
}
