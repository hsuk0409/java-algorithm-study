package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MakePrimeNumberTest {
    @DisplayName("숫자 세개 더해서 소수 갯수 구하기")
    @Test
    void test() {
        int[] nums = new int[] {1,2,7,6,4};

        int primeCnt = findPrimeNumberCanBeMade(nums);
        assert (primeCnt == 4);
    }

    public int findPrimeNumberCanBeMade(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 2) break;
                    if (sum == 2) {
                        ++result;
                    } else {
                        boolean isPrime = true;
                        for (int n = 2; n < sum; ++n) {
                            if (sum % n == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime) ++result;
                    }
                }
            }
        }

        return result;
    }
}
