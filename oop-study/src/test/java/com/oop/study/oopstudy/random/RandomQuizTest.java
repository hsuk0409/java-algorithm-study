package com.oop.study.oopstudy.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomQuizTest {
    @DisplayName("랜덤함수 테스트")
    @Test
    void test() {
        final int from = 1;
        final int to = 100;

        for (int i = 0; i < 100; ++i) {
            int randomNumber = getRandomNumberUsingMathFunc(from, to);
            System.out.print(randomNumber + " ");
            randomNumber = getRandomNumberUsingRandomFunc(to + 1);
            System.out.print(randomNumber);
            System.out.println();
        }
    }

    public int getRandomNumberUsingMathFunc(int from, int to) {
        return (int)(Math.random() * to) + from;
    }

    public int getRandomNumberUsingRandomFunc(int to) {
        Random random = new Random();

        return random.nextInt(to);
    }
}
