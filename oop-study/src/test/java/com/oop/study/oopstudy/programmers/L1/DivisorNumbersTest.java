package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivisorNumbersTest {
    @DisplayName("나누어 떨어지는 숫자들 배열로 반환")
    @Test
    void test() {
        int[] arr = new int[]{10,3,2,5,8};
        int[] expect = new int[]{2,8,10};

        int[] result = findDivisorNumbers(arr, 2);
        assert (result.length == expect.length);
        for (int i = 0; i < result.length; ++i) {
            assert (result[i] == expect[i]);
        }

        result = findDivisorNumbers(arr, 6);
        assert (result.length == 1);
        assert (result[0] == -1);
    }

    public int[] findDivisorNumbers(int[] arr, int divisor) {
        Arrays.sort(arr);

        List<Integer> tmp = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) tmp.add(num);
        }

        final int SIZE = tmp.size();
        if (SIZE == 0) return new int[]{-1};

        int[] result = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            result[i] = tmp.get(i);
        }

        return result;
    }
}
