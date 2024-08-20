package com.example.Person.controller;


import com.example.Person.service.PeopleService;
import com.example.Person.model.Person;
import com.example.Person.service.PersonController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller()
    @RequestMapping("/api")
    public class PeopleApiController {

        @Autowired
     private  PersonController peopleService;

        // Routes here
        @GetMapping("/allperson")
        public List<Person> getAllPeople() {

            return peopleService.findAllPeople();
        }

    @GetMapping("{id}")
    public Person getPerson(@PathVariable long id) {

        return peopleService.findById(id);
    }

    @PostMapping("/addperson")
    public String addPerson(@RequestBody Person person) {

        if(person != null) {
            peopleService.insert(person);
            return "Added a person";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") long id) {

        if(id > 0) {
            if(peopleService.delete(id)) {
                return "Deleted the person.";
            } else {
                return "Cannot delete the person.";
            }
        }
        return "The id is invalid for the person.";
    }

    @PutMapping("")
    public String updatePerson(@RequestBody Person person) {
        if(person != null) {
            peopleService.update(person);
            return "Updated person.";
        } else {
            return "Request does not contain a body";
        }
    }
    }

