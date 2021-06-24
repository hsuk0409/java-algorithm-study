package com.oop.study.oopstudy.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FiboOptimizationTest {

    /** 개념
     - fib(6) 구하려면 fib(5) fib(4) 필요  -> 1. 아래 값이 있으면 윗 값을 계산 가능
     - fib(5) 구하려면 fib(4) fib(3) 필요  -> 2. 윗 값은 바로 아래 값에 의존
     - fib(4) 구하려면 fib(3) fib(2) 필요
     - fib(3) 구하려면 fib(2) fib(1) 필요
     - fib(2) 구하려면 fib(1) fib(0) 필요
     - fib(1) 은 1
     - fib(0) 은 0
     */
    @DisplayName("타뷸레이션으로 최적화된 피보나치 수열")
    @Test
    void fiboTest0() {
        int result = fibonacciTabulation(35);

        assertThat(result, is(9227465));
    }

    private int fibonacciTabulation(int num) {
        int ret = 0;
        int prePre = 0;
        int pre = 1;

        for (int i = 2; i <= num; ++i) {
            ret = prePre + pre;
            prePre = pre;
            pre = ret;
        }

        return ret;
    }

    @DisplayName("메모이제이션으로 최적화된 피보나치 수열")
    @Test
    void fiboTest1() {
        int param = 35;

        int result = fibonacciOptimizationRecursive(param, new int[param + 1]);

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

    @DisplayName("일반 피보나치 수열")
    @Test
    void fiboTest2() {
        int result = fibonacciRecursive(35);

        assertThat(result, is(9227465));
    }

    private int fibonacciRecursive(int num) {
        if (num == 1) return 1;
        else if (num == 2) return 1;
        else return fibonacciRecursive(num - 2) + fibonacciRecursive(num - 1);
    }
}
