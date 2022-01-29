package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTokenizerTest {

    @Test
    @DisplayName("자바 문자열 토큰화 테스트하기")
    void tokenizerTest() {
        //given
        String str = "Hi, my name is justin!!";
        String[] results = {"Hi,", "my", "name", "is", "justin!!"};

        //when
        StringTokenizer tokenizer = new StringTokenizer(str, " ");

        //then
        assertThat(tokenizer.countTokens()).isEqualTo(5);
        for (int i = 0; tokenizer.hasMoreElements(); ++i) {
            String token = tokenizer.nextToken();
            assertThat(token).isEqualTo(results[i]);
        }
    }
}
