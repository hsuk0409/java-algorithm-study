package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReverseWordTest {
    @DisplayName("Char 배열을 이용한 단어 뒤집기")
    @Test
    void test() {
        String str = "Hi, my name is justin";
        String expected = "justin is name my Hi,";

        String result = reverseWord(str);
        assert (result.equals(expected));
    }

    public String reverseWord(String str) {
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();

        int end = chars.length - 1;
        for (int i = chars.length - 1; i > -1; --i) {
            if (chars[i] == ' ') {
                int start = i + 1;
                while (start <= end) {
                    result.append(chars[start++]);
                }
                result.append(" ");
                end = i - 1;
            }
        }

        for (int i = 0; i <= end; ++i) {
            result.append(chars[i]);
        }

        return result.toString();
    }
}
