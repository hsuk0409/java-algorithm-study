package com.oop.study.oopstudy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgLang {
    private String name;
    private int usingCount;

    @Builder
    public ProgLang(String name, int usingCount) {
        this.name = name;
        this.usingCount = usingCount;
    }

    public void changeName(String name) {
        this.name= name;
    }

    public void changeUsingCount(int usingCount) {
        this.usingCount = usingCount;
    }
}
