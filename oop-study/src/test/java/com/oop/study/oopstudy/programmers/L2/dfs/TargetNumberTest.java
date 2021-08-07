package com.oop.study.oopstudy.programmers.L2.dfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TargetNumberTest {
    @DisplayName("배열에서 연산 후 타겟 넘버가 나오는 경우의 수 구하기")
    @Test
    void test() {
        int[] numbers = new int[] {1, 1, 1, 1, 1};

        int result = getCntEqTarget1(numbers, 3);
        assert (result == 5);
    }

    @DisplayName("배열에서 연산 후 타겟 넘버가 나오는 경우의 수 구하기 다른 코드")
    @Test
    void test2() {
        int[] numbers = new int[] {1, 1, 1, 1, 1};

        int result = getCntEqTarget2(numbers, 3);
        assert (result == 5);
    }

    public int getCntEqTarget1(int[] numbers, int target) {
        int cur = numbers[0];
        int result = 0;

        result += dfs1(cur, 1, numbers, target);
        result += dfs1(-cur, 1, numbers, target);

        return result;
    }

    public int dfs1(int num, int i, int[] numbers, int target) {
        if (i >= numbers.length) {
            return (num == target) ? 1 : 0;
        }

        int cur1 = num + numbers[i];
        int cur2 = num - numbers[i];

        int result = 0;
        result += dfs1(cur1, i + 1, numbers, target);
        result += dfs1(cur2, i + 1, numbers, target);

        return result;
    }

    public int getCntEqTarget2(int[] numbers, int target) {
        return dfs2(numbers, target, 0, 0);
    }

    private int dfs2(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            return (sum == target) ? 1 : 0;
        }

        int cnt = 0;
        cnt += dfs2(numbers, target, depth + 1, sum + numbers[depth]);
        cnt += dfs2(numbers, target, depth + 1, sum - numbers[depth]);

        return  cnt;
    }
}
