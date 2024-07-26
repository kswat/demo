package com.example;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    public Optional<Person> createPerson(Person itemDto) {
        return Optional.empty();
    }
}
