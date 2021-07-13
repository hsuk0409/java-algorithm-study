package com.oop.study.oopstudy.programmers.kakao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NumberAndStringTest {
    @DisplayName("해시맵 만들어서 탐색")
    @Test
    void test() {
        String s = "12five4threesixseven123";
        int mySolution = mySolution(s);

        assertThat(mySolution, is(1254367123));
    }

    @DisplayName("String ReplaceAll 사용")
    @Test
    void test2() {
        String s = "12five4threesixseven123";
        int otherSolution = otherSolution(s);

        assertThat(otherSolution, is(1254367123));
    }

    public int otherSolution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < arr.length; i++) {
            if (s.contains(arr[i])) {
                s = s.replaceAll(arr[i], String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }

    public int mySolution(String s) {
        Map<String, Integer> map = getNumFromMap();
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c > 47 && c < 58) {
                sb.append(c);
            } else {
                tmp += String.valueOf(c);
            }

            if (tmp.length() > 2 && map.containsKey(tmp)) {
                sb.append(map.get(tmp));
                tmp = "";
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public Map<String, Integer> getNumFromMap() {
        Map<String, Integer> map = new HashMap<>();
        String[] strs = new String[] { "zero", "one", "two", "three",
                "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < 10; ++i) {
            map.put(strs[i], i);
        }

        return map;
    }
}
