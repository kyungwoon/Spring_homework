package com.example.homework.controller;

import com.example.homework.domain.Person;
import com.example.homework.domain.PersonRepository;
import com.example.homework.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;


    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // person의 정보를 가져온다.

        // 저장하는 것은 Dto가 아니라 Person이니, Dto의 정보를 person에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Person person = new Person(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return personRepository.save(person);
    }

    @GetMapping("/api/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }



}
