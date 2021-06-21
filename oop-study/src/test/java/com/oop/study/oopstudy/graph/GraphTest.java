package com.oop.study.oopstudy.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @DisplayName("보드 비어있을 때")
    @Test
    void ticTacToeTest1() {
        Player[] board = new Player[TicTacToe.BOARD_SIZE];

        int index = TicTacToe.getBestMoveIndex(board, Player.X);

        assertThat(index).isEqualTo(0);
    }

    @DisplayName("가장 놓기 좋은 색인 7일 때")
    @Test
    void ticTacToeTest2() {
        Player[] board = new Player[]{
                null, Player.O, Player.X,
                Player.X, Player.O, Player.O,
                null, null, Player.X};

        int index = TicTacToe.getBestMoveIndex(board, Player.X);

        assertThat(index).isEqualTo(7);
    }

    @DisplayName("가장 놓기 좋은 색인 4일 때")
    @Test
    void ticTacToeTest3() {
        Player[] board = new Player[]{
                Player.O, null, Player.X,
                Player.X, null, Player.X,
                null, Player.O, Player.O};

        int index = TicTacToe.getBestMoveIndex(board, Player.X);

        assertThat(index).isEqualTo(4);
    }
}