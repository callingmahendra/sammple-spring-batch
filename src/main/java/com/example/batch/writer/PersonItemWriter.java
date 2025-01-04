package com.example.batch.writer;

import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.example.batch.entity.ProcessedPerson;

import javax.persistence.EntityManagerFactory;

public class PersonItemWriter extends JpaItemWriter<ProcessedPerson> {

    
    private EntityManagerFactory entityManagerFactory;

    public PersonItemWriter(EntityManagerFactory entityManagerFactory){
        super();
        this.setEntityManagerFactory(entityManagerFactory);

    }
    
}
