package com.oop.study.oopstudy.programmers.kakao;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class NumberAndStringTest {
    @Test
    void test() {
    }

    public int otherSolution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < arr.length; i++) {
            if (s.contains(arr[i])) {
                s = s.replaceAll(arr[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }

    public int mySolution(String s) {
        Map<String, Integer> map = getNumFromMap();
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] > 47 && chars[i] < 58) {
                sb.append(chars[i]);
            } else {
                tmp += String.valueOf(chars[i]);
            }

            if (tmp.length() > 2 && map.containsKey(tmp)) {
                System.out.println(tmp);
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
