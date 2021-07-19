package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PockemonTest {

    @DisplayName("포켓몬 문제, n/2의 최소 조합 가져오기")
    @Test
    void test() {
        int[] nums = new int[] {3, 4, 1, 2, 2, 3, 3};

        int minOptimalSize = getMinOptimalSize(nums);

        assertThat(minOptimalSize, is(3));
    }

    public int getMinOptimalSize(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length / 2;

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), n);
    }
}
