package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {

    @DisplayName("문자열 비교 테스트#1")
    @Test
    void stringCompareTest1() {
        //given
        String str1 = "Justin";
        String str2 = "Justin";
        String str3 = new String("Justin");

        //when
        boolean isSame1 = str1 == str2;
        boolean isSame2 = str1.equals(str2);
        boolean isSame3 = str1 == str3;
        boolean isSame4 = str1.equals(str3);

        //then
        assertThat(isSame1).isTrue();
        assertThat(isSame2).isTrue();
        assertThat(isSame3).isFalse();
        assertThat(isSame4).isTrue();
    }
}
