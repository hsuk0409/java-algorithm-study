package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PushPhoneNumberTest {
    private final int[][] padPos = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2}
    };

    private int[] lPos = {3, 0};
    private int[] rPos = {3, 2};

    @DisplayName("키패드 누르기 문제, 괜찮은 코드 가져와서 디버깅 해보기")
    @Test
    void test() {
        int[] nums = new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        String changedNumPosToStr = getChangedNumPosToStr(nums, "right");

        assertThat(changedNumPosToStr, is("LRLLLRLLRRL"));
    }

    public String getChangedNumPosToStr(int[] nums, String hand) {
        String handStr = hand.equals("right") ? "R" : "L";

        StringBuilder result = new StringBuilder();
        for (int n : nums) {
            String umji = moveHand(n, handStr);
            result.append(umji);

            if (umji.equals("L")) {
                lPos = padPos[n];
            } else {
                rPos = padPos[n];
            }
        }

        return result.toString();
    }

    private String moveHand(int n, String hand) {
        if (n == 1 || n == 4 || n == 7) return "L";
        if (n == 3 || n == 6 || n == 9) return "R";

        if (getDist(lPos, n) > getDist(rPos, n)) return "R";
        if (getDist(lPos, n) < getDist(rPos, n)) return "L";

        return hand;
    }

    private int getDist(int[] pos, int n) {
        return Math.abs(pos[0] - padPos[n][0]) + Math.abs(pos[1] - padPos[n][1]);
    }
}
