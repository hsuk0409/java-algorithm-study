package com.oop.study.oopstudy.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FiboOptimizationTest {

    @DisplayName("메모이제이션으로 최적화된 피보나치 수열")
    @Test
    void fiboTest() {
        int param = 35;

        int result = fibonacciOptimizationRecursive(param, new int[param + 1]);

        assertThat(result, is(9227465));
    }

    @DisplayName("일반 피보나치 수열")
    @Test
    void fiboTest2() {
        int result = fibonacciRecursive(35);

        assertThat(result, is(9227465));
    }

    private int fibonacciOptimizationRecursive(int num, int[] cache) {
        if (num <= 1) return num;

        if (cache[num] != 0) {
            return cache[num];
        }

        int ret = fibonacciOptimizationRecursive(num - 2, cache) + fibonacciOptimizationRecursive(num - 1, cache);

        cache[num] = ret;

        return ret;
    }

    private int fibonacciRecursive(int num) {
        if (num == 1) return 1;
        else if (num == 2) return 1;
        else return fibonacciRecursive(num - 2) + fibonacciRecursive(num - 1);
    }
}
