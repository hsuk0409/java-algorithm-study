package com.oop.study.oopstudy.programmers.L1.greedy;

import java.util.Arrays;
import java.util.HashSet;

public class WorkClothesTest {

    public int getOptimizationShareCount(int m, int[] lost, int[] reserve) {
        int answer = reserve.length == 1 ? 2 : reserve.length;
        HashSet<Integer> discovered = new HashSet<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; ++i) {
            for (int k = 0; k < lost.length; ++k) {
                if (lost[k] == (reserve[i] - 1) || lost[k] == (reserve[i] + 1)) {
                    if (!discovered.contains(lost[k])) {
                        discovered.add(lost[k]);
                        ++answer;
                    }
                }
            }
        }

        return answer;
    }
}
