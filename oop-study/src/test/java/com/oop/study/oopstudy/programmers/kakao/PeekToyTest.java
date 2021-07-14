package com.oop.study.oopstudy.programmers.kakao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PeekToyTest {
    @DisplayName("크레인 인형뽑기 게임 풀어보기")
    @Test
    void test() {
        int[][] board = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        int[] moves = new int[] {1,5,3,5,1,2,1,4};

        int result = getSamePeekCount(board, moves);

        assertThat(result, is(4));
    }

    public int getSamePeekCount(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int preVal;

        for (int i = 0; i < moves.length; ++i) {
            for (int k = 0; k < board.length; ++k) {
                if (board[k][moves[i] - 1] != 0) {
                    stack.push(board[k][moves[i] - 1]);
                    board[k][moves[i] - 1] = 0;

                    if (stack.size() > 1) {
                        preVal = stack.pop();
                        if (preVal == stack.peek()) {
                            stack.pop();
                            result += 2;
                        } else {
                            stack.push(preVal);
                        }
                    }
                    break;
                }
            }
        }

        return result;
    }
}
