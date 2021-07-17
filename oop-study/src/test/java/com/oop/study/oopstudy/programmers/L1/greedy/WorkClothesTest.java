package com.oop.study.oopstudy.programmers.L1.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WorkClothesTest {

    @DisplayName("그리디 체육복 문제")
    @Test
    void test() {
        int n = getOptimizationShareCount(10, new int[]{5, 4, 3, 2, 1}, new int[]{3, 1, 2, 5, 4});

        assertThat(n, is(10));
    }

    public int getOptimizationShareCount(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; ++i) {
            for (int k = 0; k < reserve.length; ++k) {
                if (lost[i] == reserve[k]) {
                    ++answer;
                    lost[i] = -1;
                    reserve[k] = -1;
                    break;
                }
            }
        }

        for (int j : lost) {
            for (int k = 0; k < reserve.length; ++k) {
                if ((j - 1) == reserve[k] || (j + 1) == reserve[k]) {
                    ++answer;
                    reserve[k] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
