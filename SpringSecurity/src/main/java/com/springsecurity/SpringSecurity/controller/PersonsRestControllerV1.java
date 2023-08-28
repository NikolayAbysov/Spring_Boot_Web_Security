package com.springsecurity.SpringSecurity.controller;

import com.springsecurity.SpringSecurity.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonsRestControllerV1 {
    private List<Person> PERSONS = List.of(
            new Person(1L, "Doe1", "Joe1"),
            new Person(2L, "Doe2", "Joe2"),
            new Person(3L, "Doe3", "Joe3")
    );

    @GetMapping
    public List<Person> getPersons(){
        return PERSONS;
    }
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        return PERSONS.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .get();
    }
}
