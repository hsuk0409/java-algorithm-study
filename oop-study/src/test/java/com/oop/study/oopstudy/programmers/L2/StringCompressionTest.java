package com.oop.study.oopstudy.programmers.L2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCompressionTest {
    @DisplayName("같은 문자열 찾아서 압축하기")
    @Test
    void test() {
        String s = "aabbaccc";
        int result = getStrLengthAfterCompression(s);
        assert (result == 7);
    }

    public int getStrLengthAfterCompression(String s) {
        int len = s.length();

        for (int i = 1; i <= s.length() / 2; ++i) {
            int compLength = compression(s, i).length();
            len = Math.min(len, compLength);
        }

        return len;
    }

    private String compression(String str, int i) {
        int cnt = 0;
        String compression = "";
        String pattern = "";

        for (int k = 0; k <= str.length() + i; k += i) {
            String nowStr;

            if (k >= str.length()) nowStr = "";
            else if (str.length() < (k + i)) nowStr = str.substring(k);
            else nowStr = str.substring(k, k + i);

            if (k != 0) {
                if (nowStr.equals(pattern)) ++cnt;
                else if (cnt >= 2) {
                    compression += cnt + pattern;
                    ++cnt;
                } else {
                    compression += pattern;
                }
            }
            pattern = nowStr;
        }

        return compression;
    }
}
