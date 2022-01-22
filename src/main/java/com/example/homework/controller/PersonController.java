package com.example.homework.controller;

import com.example.homework.domain.Person;
import com.example.homework.domain.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;


    @GetMapping("/api/persons")
    public List<Person> getCourses() {
        return personRepository.findAll();
    }

}
