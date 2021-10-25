package com.oop.study.oopstudy.thread.multithread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultiThreadCountTest {

    @DisplayName("여러 스레드로 동시성 테스트")
    @Test
    void test(){
        Count count = new Count();

        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                for (int k = 0; k < 10; ++k) {
                    System.out.println(count.addCount());
                }
            }).start();
        }
    }
}

class Count {
    private int count;

    public int addCount() {
        return count++;
    }
}
