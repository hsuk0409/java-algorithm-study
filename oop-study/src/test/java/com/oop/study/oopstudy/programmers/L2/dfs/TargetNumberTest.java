package com.oop.study.oopstudy.programmers.L2.dfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TargetNumberTest {
    @DisplayName("배열에서 연산 후 타겟 넘버가 나오는 경우의 수 구하기")
    @Test
    void test() {
        int[] numbers = new int[] {1, 1, 1, 1, 1};

        int result = getCntEqTarget(numbers, 3);
        assert (result == 5);
    }

    public int getCntEqTarget(int[] numbers, int target) {
        int cur = numbers[0];
        int result = 0;

        result += dfs(cur, 1, numbers, target);
        result += dfs(-cur, 1, numbers, target);

        return result;
    }

    public int dfs(int num, int i, int[] numbers, int target) {
        if (i >= numbers.length) {
            if (num == target) return 1;
            return 0;
        }

        int cur1 = num + numbers[i];
        int cur2 = num - numbers[i];

        int result = 0;
        result += dfs(cur1, i + 1, numbers, target);
        result += dfs(cur2, i + 1, numbers, target);

        return result;
    }
}
