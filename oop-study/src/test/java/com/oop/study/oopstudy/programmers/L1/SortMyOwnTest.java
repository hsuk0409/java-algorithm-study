package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMyOwnTest {
    @DisplayName("조건에 따른 정렬 구현하기")
    @Test
    void test() {
        String[] strings = new String[] {"cdx","abce", "abcd"};
        String[] expect = new String[] {"abcd","abce", "cdx"};

        String[] result = sortMyOwn(strings, 2);

        for (int i = 0; i < result.length; ++i) {
            assert (result[i].equals(expect[i]));
        }
    }

    public String[] sortMyOwn(String[] strings, int n) {
        int length = strings.length;
        List<String> tmpArr = new ArrayList<>();
        for (String string : strings) {
            tmpArr.add(string.charAt(n) + string);
        }

        Collections.sort(tmpArr);

        String[] result = new String[strings.length];
        for (int i = 0; i < length; ++i) {
            result[i] = tmpArr.get(i).substring(1);
        }

        return result;
    }
}
