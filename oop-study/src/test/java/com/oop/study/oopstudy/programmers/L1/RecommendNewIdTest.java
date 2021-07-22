package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RecommendNewIdTest {
    @DisplayName("아이디 유효성 검사 후 가능한 아이디로 추천해주기")
    @Test
    void test() {
        String id = "AB_-$%^!...CC";

        String newId = getRecommendedNewId(id);

        assertThat(newId, is("ab_-.cc"));
    }

    public String getRecommendedNewId(String userId) {
        StringBuilder sb = new StringBuilder();
        String id = userId.toLowerCase();
        char[] chars = id.toCharArray();

        for (char c : chars) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        for (int i = 0; i < sb.length() - 1; ++i) {
            if (sb.charAt(i) == '.' && (sb.charAt(i) == sb.charAt(i + 1))) {
                sb.deleteCharAt(i--);
            }
        }

        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 15) {
            sb.delete(15, sb.length());
        }
        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() < 1) {
            sb.append("a");
        }

        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }
}
