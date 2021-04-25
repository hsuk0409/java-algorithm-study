package com.oop.study.oopstudy.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TailRecursionTest {

    @DisplayName("스택 프레임 몇개가 쌓이는지 디버깅 해보기")
    @Test
    public void tailRecursion() {
        puff(4, 6, 4);
    }

    public void puff(int n, int a, int b) {
        if (n <= 0) {
            return;
        }

        log.info(String.format("%d %d %d", n, a, b));

        puff(n - 3, a, b + n);
        puff(n - 1, b, a + n);
        puff(n - 2, b, a + n);
    }
}
