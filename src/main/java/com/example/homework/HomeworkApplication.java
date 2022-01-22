package com.example.homework;

import com.example.homework.domain.Person;
import com.example.homework.domain.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing // 생성, 수정일자 자동 업데이트
@SpringBootApplication
public class HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository){
        return (args) -> {
            // 데이터 저장하기
            personRepository.save(new Person("홍길동", "서울특별시" ));

            List<Person> personList = personRepository.findAll();
            for(int i = 0; i < personList.size(); i++){
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAddress());
            }

        };
    }

}
