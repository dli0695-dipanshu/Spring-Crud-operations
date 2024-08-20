package com.example.Person.service;

import com.example.Person.model.Person;

import java.util.List;

public interface PeopleService {
    List<Person> findAllPeople();
    Person findById(long id);
    Person insert(Person p);
    boolean delete(long id);
    boolean update(Person p);
}
