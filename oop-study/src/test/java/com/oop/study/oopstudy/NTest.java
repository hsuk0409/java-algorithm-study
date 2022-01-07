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

    @Test
    void secondTest2() {
        int[][] boards = new int[][] {
                {0, 1},
                {0, 2},
                {-1, -1},
                {-1, -1},
                {-1, -1},
                {-1, -1}
        };

        int num = 4;
        List<Integer> result = processSomething(boards, num);
        List<Integer> tmp = Arrays.asList(1, 2);

        for (int i = 0; i < result.size(); ++i) {
            assertThat(result.get(i)).isEqualTo(tmp.get(i));
        }
    }

    private List<Integer> processSomething(int[][] boards, final int num) {
        int tmpNum = 0;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Queue<Integer>> queues = new HashMap<>();

        for (int[] board : boards) {
            if (greaterThenOrEqualZero(board[0])) {
                pushBucket(queues, board);
            } else {
                if (queues.size() == 0 || queues.get(0).size() <= 0) continue;

                Queue<Integer> queue = queues.get(tmpNum++);
                if (queue == null || queue.size() <= 0) {
                    while (queues.get(tmpNum) == null) {
                        ++tmpNum;
                        if (tmpNum == num) tmpNum = 0;
                    }
                    queue = queues.get(tmpNum);
                }
                popBucketAndSave(result, queue);
                if (tmpNum == num) tmpNum = 0;
            }
        }

        return result;
    }

    private boolean greaterThenOrEqualZero(int num) {
        return num > -1;
    }

    private void pushBucket(Map<Integer, Queue<Integer>> queues, int[] board) {
        if (queues.size() < 1 || queues.get(board[0]) == null) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(board[1]);
            queues.put(board[0], queue);
        } else {
            queues.get(board[0]).add(board[1]);
        }
    }

    private void popBucketAndSave(List<Integer> result, Queue<Integer> queue) {
        Integer poll = queue.poll();
        result.add(poll);
    }
}
