package com.example.Person.service;

import com.example.Person.model.Person;
import com.example.Person.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonController implements PeopleService {
    @Autowired
    private PersonRepository repository;

    @Override
    public List<Person> findAllPeople() {

        log.debug("find all method");
        return (List<Person>)repository.findAll();
    }

    @Override
    public Person insert(Person p) {
        log.debug("insert method");
        return repository.save(p);
    }

    @Override
    public boolean delete(long id) {
        try {
            log.debug("delete method");
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Person findById(long id) {
        log.debug("find by id method");
        Optional<Person> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Person p) {

        try {
            log.debug("update method");
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
