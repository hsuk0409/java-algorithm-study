package com.spring.corestudy.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member {
    private Long id;
    private String name;
    private Grade grade;
}
