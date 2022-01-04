package com.oop.study.oopstudy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NTest {

    @Test
    void secondTest() {
        int[][] boards = new int[][] {
                {0, 1},
                {0, 2},
                {1, 1},
                {2, 2},
                {1, 2},
                {-1, -1},
                {-1, -1},
                {0, 6},
                {-1, -1},
                {4, 7},
                {1, 3},
                {-1, -1}
        };

        int num = 4;
        List<Integer> result = processSomething(boards, num);
        List<Integer> tmp = Arrays.asList(1, 1, 2, 7);

        for (int i = 0; i < result.size(); ++i) {
            assertThat(result.get(i)).isEqualTo(tmp.get(i));
        }
    }

    private List<Integer> processSomething(int[][] boards, final int num) {
        int tmpNum = 0;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Queue<Integer>> queues = new HashMap<>();

        for (int[] board : boards) {
            if (board[0] > -1) {
                if (queues.size() < 1 || queues.get(board[0]) == null) {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(board[1]);
                    queues.put(board[0], queue);
                } else {
                    queues.get(board[0]).add(board[1]);
                }
            } else {
                if (queues.size() == 0) continue;

                Queue<Integer> queue = queues.get(tmpNum++);
                if (queue != null) {
                    Integer poll = queue.poll();
                    result.add(poll);
                } else {
                    while (queues.get(tmpNum) == null) {
                        ++tmpNum;
                        if (tmpNum == num) tmpNum = 0;
                    }
                    queue = queues.get(tmpNum);
                    Integer poll = queue.poll();
                    result.add(poll);
                }
                if (tmpNum == num) tmpNum = 0;
            }
        }

        return result;
    }
}
