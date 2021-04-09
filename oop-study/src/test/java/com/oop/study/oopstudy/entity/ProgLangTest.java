package com.oop.study.oopstudy.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgLangTest {

    @Test
    @DisplayName("개체 생성해서 다른 개체에 대입하면 주소가 복사된다.")
    public void createTest() {
        //given
        ProgLang ob1 = ProgLang.builder()
                .name("C")
                .usingCount(10)
                .build();
        ProgLang ob2;

        //when
        ob2 = ob1;
        String name = "JAVA";
        ob2.changeName(name);
        ob2.changeUsingCount(15);

        //then
        assertThat(ob1.getName()).isEqualTo(name);
        assertThat(ob1.getUsingCount()).isEqualTo(15);
    }
}
