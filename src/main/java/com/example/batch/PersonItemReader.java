package com.example.batch;

import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

public class PersonItemReader extends JpaPagingItemReader<Person> {

    public PersonItemReader(EntityManagerFactory entityManagerFactory) {
        this.setEntityManagerFactory(entityManagerFactory);
        this.setQueryString("SELECT p FROM Person p");
        this.setPageSize(10);
    }
}
