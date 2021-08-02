package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertDartResultStrToScoreTest {
    @DisplayName("다트게임 문제, 문자열에서 규칙 찾아서 점수 계산하기")
    @Test
    void test() {
        String dt = "1D2S#10S";

        int score = getConvertedScore(dt);
        assert (score == 9);
    }

    public int getConvertedScore(String dartResult) {
        int[] nums = new int[3];
        int idx = 0;

        String str = "";
        for (int i = 0; i < dartResult.length(); ++i) {
            char c = dartResult.charAt(i);

            if (c >= '0' && c <= '9') {
                str += String.valueOf(c);
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int n = Integer.parseInt(str);

                if (c == 'D') n = (int)Math.pow(n, 2);
                else if (c == 'T') n = (int)Math.pow(n, 3);

                nums[idx++] = n;
                str = "";
            } else {
                if (c == '#') {
                    nums[idx - 1] *= -1;
                } else {
                    nums[idx - 1] *= 2;
                    if (idx - 2 >= 0) nums[idx - 2] *= 2;
                }
            }
        }

        int result = 0;
        for (int n : nums) result += n;

        return result;
    }
}
