package com.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public ItemReader<Person> reader() {
        return new PersonItemReader(entityManagerFactory);
    }

    @Bean
    public ItemProcessor<Person, ProcessedPerson> processor() {
        return person -> new ProcessedPerson(person.getFirstName(), person.getLastName());
    }

    @Bean
    public ItemWriter<ProcessedPerson> writer() {
        return new PersonItemWriter(entityManagerFactory);
    }

    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1, JobExecutionListenerSupport listener) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader,
                      ItemProcessor<Person, ProcessedPerson> processor, ItemWriter<ProcessedPerson> writer) {
        return stepBuilderFactory.get("step1")
                .<Person, ProcessedPerson>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
