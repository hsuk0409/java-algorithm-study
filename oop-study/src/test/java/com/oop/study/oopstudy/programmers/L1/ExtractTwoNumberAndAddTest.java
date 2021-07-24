package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ExtractTwoNumberAndAddTest {
    @DisplayName("숫자 두개 더해서 결과 담은 배열 가져오기")
    @Test
    void test() {
        int[] numbers = new int[] {2,1,3,4,1};
        int[] result = new int[] {2,3,4,5,6,7};

        int[] resultNums = getTwoNumberAdd(numbers);

        assert (result.length == resultNums.length);
        for (int i = 0; i < resultNums.length; ++i) {
            assert (result[i] == resultNums[i]);
        }
    }

    public int[] getTwoNumberAdd(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; ++i) {
            for (int k = i + 1; k < numbers.length; ++k) {
                set.add(numbers[i] + numbers[k]);
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int i : set) {
            result[index++] = i;
        }

        Arrays.sort(result);

        return result;
    }
}
