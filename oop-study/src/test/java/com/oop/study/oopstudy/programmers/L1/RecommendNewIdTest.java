package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RecommendNewIdTest {
    @DisplayName("아이디 유효성 검사 후 가능한 아이디로 추천해주기(내코드)")
    @Test
    void test() {
        String id = "AB_-$%^!...CC";
        String test = "BB.......................................................";

        String newId = getRecommendedNewId(id);
        assertThat(newId, is("ab_-.cc"));

        newId = getRecommendedNewId(test);
        assertThat(newId, is("bbb"));
    }

    @DisplayName("아이디 유효성 검사 후 가능한 아이디로 추천해주기(다른 사람 코드)")
    @Test
    void test2() {
        String id = "AB_-$%^!...CC";
        String test = "BB.......................................................";

        String newId2 = getUsingRegex(id);
        assertThat(newId2, is("ab_-.cc"));

        newId2 = getUsingRegex(test);
        assertThat(newId2, is("bbb"));
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

    public String getUsingRegex(String newId) {
        String answer = "";
        String temp = newId.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]", "");
        temp = temp.replaceAll("[.]{2,}", ".");
        temp = temp.replaceAll("^[.]|[.]$", "");

        if (temp.equals("")) {
            temp += "a";
        }

        if (temp.length() >= 16) {
            temp = temp.substring(0, 15);
            temp = temp.replaceAll("^[.]|[.]$", "");
        }

        if (temp.length() <= 2) {
            while (temp.length() < 3) {
                temp += temp.charAt(temp.length() - 1);
            }
        }

        answer = temp;
        return answer;
    }
}
