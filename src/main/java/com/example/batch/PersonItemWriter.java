package com.example.batch;

import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

public class PersonItemWriter extends JpaItemWriter<ProcessedPerson> {

    
    public PersonItemWriter(EntityManagerFactory entityManagerFactory) {
        super();
        setEntityManagerFactory(entityManagerFactory);
    }
}
