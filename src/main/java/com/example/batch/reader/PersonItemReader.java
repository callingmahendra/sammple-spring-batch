package com.example.batch.reader;

import com.example.batch.entity.Person;
import org.springframework.batch.item.database.JpaPagingItemReader;

import javax.persistence.EntityManagerFactory;

public class PersonItemReader extends JpaPagingItemReader<Person> {

    public PersonItemReader(EntityManagerFactory entityManagerFactory) {
        this.setEntityManagerFactory(entityManagerFactory);
        this.setQueryString("SELECT p FROM Person p");
        this.setPageSize(10);
    }
}
