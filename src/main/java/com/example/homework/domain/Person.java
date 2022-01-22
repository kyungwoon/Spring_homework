package com.example.homework.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.

public class Person extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

    @Column(nullable = false)
    private String address;


    public Person(String name, String address) {
        this.name = name;
        this.address = address;

    }
    public void update(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();
    }

    public Person(PersonRequestDto requestDto){
        this.name = requestDto.getName();
        this.address = requestDto.getAddress();

    }


}
