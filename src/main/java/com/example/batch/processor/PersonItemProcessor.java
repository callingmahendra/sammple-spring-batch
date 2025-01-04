package com.example.batch.processor;

import com.example.batch.entity.Person;
import com.example.batch.entity.ProcessedPerson;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, ProcessedPerson> {

    @Override
    public ProcessedPerson process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final ProcessedPerson transformedPerson = new ProcessedPerson(firstName, lastName);

        System.out.println("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }
}
