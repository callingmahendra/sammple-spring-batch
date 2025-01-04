package com.example.batch.config;

import com.example.batch.entity.Person;
import com.example.batch.entity.ProcessedPerson;
import com.example.batch.listener.JobCompletionNotificationListener;
import com.example.batch.processor.PersonItemProcessor;
import com.example.batch.reader.PersonItemReader;
import com.example.batch.writer.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.swing.text.html.parser.Entity;

@Configuration
@EnableBatchProcessing
public class PersonJobConfiguration {

    
    @Bean
    public Job importUserJob(JobBuilderFactory jobs, Step s1, JobCompletionNotificationListener listener) {
        return jobs.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, EntityManagerFactory entityManagerFactory) {
        return stepBuilderFactory.get("step1")
                .<Person, ProcessedPerson>chunk(10)
                .reader(new PersonItemReader(entityManagerFactory))
                .processor(new PersonItemProcessor())
                .writer(new PersonItemWriter(entityManagerFactory))
                .build();
    }
}
