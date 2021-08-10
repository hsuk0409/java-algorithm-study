package com.oop.study.oopstudy.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgoTest {
    @DisplayName("KMP 알고리듬")
    @Test
    void test() {
        String str = "aaaabaaaac";
        String patten = "aaaac";

        List<Integer> result = kmpSearch(str, patten);
        assert (result.get(0) == 6);
    }

    /** 커누스-모리스-플랫
     * H: haystack (짚더미)
     * N: needle (바늘)
     * -> 짚더미에서 바늘 찾기
     */
    public List<Integer> kmpSearch(final String H, final String N) {
        int hLen = H.length();
        int nLen = N.length();

        List<Integer> result = new ArrayList<>();
        int[] pi = getPartialMatch(N);
        char[] s = H.toCharArray();
        char[] p = N.toCharArray();
        int matched = 0;

        for (int i = 0; i < hLen; ++i) {
            while (matched > 0 && s[i] != p[matched]) {
                matched = pi[matched - 1];
            }

            if (s[i] == p[matched]) {
                if (matched == nLen - 1) {
                    result.add(i - nLen + 1);
                    matched = pi[matched];
                } else {
                    ++matched;
                }
            }
        }

        return result;
    }

    private int[] getPartialMatch(final String pattern) {
        int len = pattern.length();
        int[] pi = new int[len];

        int matched = 0;

        for (int i = 0; i < len; ++i) {
            while (matched > 0 && pattern.charAt(i) != pattern.charAt(matched)) {
                matched = pi[matched - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(matched)) {
                pi[i] = ++matched;
            }
        }

        return pi;
    }
}
