package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class APTest {
    @DisplayName("위클리 챌린지 1주차 문제")
    @Test
    void test() {
        int price = 5;
        int money = 15;
        int count = 7;

        long result = apLoop(price, money, count);
        assert (result == 125);

        result = ap(price, money, count);
        assert (result == 125);
    }

    public long apLoop(int price, int money, int count) {
        long result = price;
        int fix = price;
        for (int i = 1; i < count; ++i) {
            price += fix;
            result += price;
        }

        return result > money ? result - money : 0;
    }

    public long ap(int price, int money, int count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }
}
