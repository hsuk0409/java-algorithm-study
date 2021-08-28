package com.oop.study.oopstudy.triagle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountOfTriangles {
    @DisplayName("주어진 둘레로 만들 수 있는 삼각형 갯수 구하기")
    @Test
    void test() {
        int cnt = findCntTrianglesCanBeMade(9);
        assert (cnt == 3);
    }

    public int findCntTrianglesCanBeMade(int n) {
        int result = 0;

        for (int i = 1; i <= n / 3; ++i) {
            for (int k = (n - i) / 2; k >= i; --k) {
                int maxSide = n - i - k;
                if (maxSide < i + k) ++result;
                else break;
            }
        }

        return result;
    }
}
