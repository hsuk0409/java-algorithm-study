package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LottoTest {
    @DisplayName("로또 최고 순위, 최저 순위 탐색")
    @Test
    void test() {
        int[] lottos = new int[] {44, 1, 0, 0, 31, 25};
        int[] winNums = new int[] {31, 10, 45, 1, 6, 19};

        int[] maxMinRank = getMaxMinRank(lottos, winNums);

        assertThat(maxMinRank[0], is(3));
        assertThat(maxMinRank[1], is(5));
    }

    public int[] getMaxMinRank(int[] myLottoNums, int[] winNums) {
        Arrays.sort(myLottoNums);
        Arrays.sort(winNums);

        int zeroCnt = 0;
        int sameCnt = 0;
        for (int myLottoNum : myLottoNums) {
            if (myLottoNum == 0) {
                ++zeroCnt;
                continue;
            }
            for (int winNum : winNums) {
                if (myLottoNum == winNum) {
                    ++sameCnt;
                }
            }
        }

        int maxRank = getRank(sameCnt + zeroCnt);
        int minRank = getRank(sameCnt);

        return new int[] {maxRank, minRank};
    }

    public int getRank(int cnt) {
        switch (cnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
