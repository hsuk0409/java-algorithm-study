package com.oop.study.oopstudy.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FiboOptiTest2 {

    @DisplayName("배열을 이용한 피보나치 최적화 연습")
    @Test
    void fiboTest0() {
        int result = fiboOptiRecursive(5, new int[6]);

        assertThat(result, is(5));
    }

    private int fiboOptiRecursive(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        int ret = fiboOptiRecursive(n - 2, cache) + fiboOptiRecursive(n - 1, cache);

        cache[n] = ret;

        return ret;
    }
}
