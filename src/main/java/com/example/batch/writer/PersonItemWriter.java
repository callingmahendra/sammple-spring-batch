package com.example.batch.writer;

import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

public class PersonItemWriter extends JpaItemWriter<ProcessedPerson> {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaItemWriter<ProcessedPerson> writer() {
        JpaItemWriter<ProcessedPerson> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }
}
