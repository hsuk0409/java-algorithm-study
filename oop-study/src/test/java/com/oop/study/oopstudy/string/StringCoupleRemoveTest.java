package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCoupleRemoveTest {

    @DisplayName("문자열 짝지어 제거하기 문제")
    @Test
    void test() {
        String s = "cdcd";
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 2) {
            for (int i = 0; i < sb.length() - 1; ++i) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    break;
                }
            }
        }
    }
}
