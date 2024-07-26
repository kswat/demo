package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    Long id;
    String firstName;
    String lastName;

    public Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }
}
