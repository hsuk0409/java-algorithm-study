package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertSnakeCaseTest {

    @DisplayName("띄어씌기와 카멜 케이스를 대문자 스네이크 케이스로 변환한다.")
    @Test
    void convertSnakeCaseTest() {
        //given
        String str = "miero fiberZon mat tang";
        String expected = "MIERO_FIBER_ZON_MAT_TANG";

        //when
        str = convertToUpperSnakeCase(str);

        //then
        assertThat(str).isEqualTo(expected);
    }

    private String convertToUpperSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (c == ' ') {
                sb.append("_");
                continue;
            }

            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(c);
                continue;
            }

            sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }
}
