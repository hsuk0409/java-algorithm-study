package com.oop.study.oopstudy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgLang {
    private String name;
    private int numberOfUsers;

    @Builder
    public ProgLang(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public void changeName(String name) {
        this.name= name;
    }

    public void changeNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
}
