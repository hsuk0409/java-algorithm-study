package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FinalTest {
    @DisplayName("[완전탐색] 모의고사 문제")
    @Test
    void test() {
        int[] answers = new int[] {1,3,2,4,2};

        int[] peoples = getMaxCorrectPeoples(answers);

        assertThat(peoples.length, is(3));
    }

    public int[] getMaxCorrectPeoples(int[] answers) {
        int[] supoza1 = new int[] {1,2,3,4,5};
        int[] supoza2 = new int[] {2,1,2,3,2,4,2,5};
        int[] supoza3 = new int[] {3,3,1,1,2,2,4,4,5,5};

        int supoCnt1 = 0;
        int supoCnt2 = 0;
        int supoCnt3 = 0;

        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == supoza1[i % supoza1.length]) ++supoCnt1;
            if (answers[i] == supoza2[i % supoza2.length]) ++supoCnt2;
            if (answers[i] == supoza3[i % supoza3.length]) ++supoCnt3;
        }

        int max = Math.max(Math.max(supoCnt1, supoCnt2), supoCnt3);

        ArrayList<Integer> list = new ArrayList<>();
        if (max == supoCnt1) list.add(1);
        if (max == supoCnt2) list.add(2);
        if (max == supoCnt3) list.add(3);

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = list.get(i);
        }

        return result;
    }
}
