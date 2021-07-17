package com.oop.study.oopstudy.programmers.L1.greedy;

import java.util.Arrays;

public class WorkClothesTest {

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
