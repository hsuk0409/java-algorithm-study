package com.oop.study.oopstudy.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringTest {
    @DisplayName("스택 메모리만 사용하여 문자열 뒤집기")
    @Test
    void reverseStringTest() {
        //given
        String str = "justin!!";

        //when
        String result = reverseStrUsingLoop(str);

        //then
        assertThat(result).isEqualTo("!!nitsuj");
    }

    private String reverseStrUsingLoop(String str) {
        char[] arr = str.toCharArray();
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            char tmp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = tmp;
        }
        return new String(arr);
    }
}
