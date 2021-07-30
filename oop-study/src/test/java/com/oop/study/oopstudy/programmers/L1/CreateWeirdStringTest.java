package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateWeirdStringTest {
    @DisplayName("이상한 문자 만들기")
    @Test
    void test() {
        String s = "Hi, my name is justin!";
        String result = "Hi, My NaMe Is JuStIn!";

        String weirdString = getWeirdString(s);
        assert (weirdString.equals(result));
    }

    public String getWeirdString(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ", -1);

        for (int i = 0; i < strs.length; ++i) {
            String str = strs[i];
            for (int k = 0; k < str.length(); ++k) {
                char c = str.charAt(k);

                if (k % 2 == 0) {
                    if (c >= 'a' && c <= 'z') c -= 32;
                } else {
                    if (c >= 'A' && c <= 'Z') c += 32;
                }

                sb.append(c);
            }

            if (i != strs.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
