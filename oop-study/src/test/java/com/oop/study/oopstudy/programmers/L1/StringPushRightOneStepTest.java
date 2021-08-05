package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringPushRightOneStepTest {
    @DisplayName("시저암호 문제, 문자열 캐릭터 다루기")
    @Test
    void test() {
        String str = "a B z";

        String result = getPushRightOneStep(str, 4);
        assert (result.equals("e F d"));
    }

    public String getPushRightOneStep(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                continue;
            }

            for (int k = 0; k < n; ++k) {
                if (c == 'z') {
                    c = 'a';
                    continue;
                } else if (c == 'Z') {
                    c = 'A';
                    continue;
                }
                ++c;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
