package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YaksuCntAddTest {
    @DisplayName("약수의 갯수와 덧셈 문제")
    @Test
    void test() {
        int yaksuAddCnt = getYaksuAddCnt(13, 17);
        assert (yaksuAddCnt == 43);
    }

    public int getYaksuAddCnt(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; ++i) {
            int cnt = 0;
            for (int k = 1; k <= i; ++k) {
                if (i % k == 0) ++cnt;
            }

            if (cnt % 2 == 0) sum += i;
            else sum -= i;
        }

        return sum;
    }
}
