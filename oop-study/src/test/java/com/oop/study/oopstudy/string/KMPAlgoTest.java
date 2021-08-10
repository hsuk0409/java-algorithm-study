package com.oop.study.oopstudy.string;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgoTest {

    /** 커누스-모리스-플랫
     * H: haystack (짚더미)
     * N: needle (바늘)
     * -> 짚더미에서 바늘 찾기
     */
    public List<Integer> kmpSearch(final String H, final String N) {
        int hLen = H.length();
        int nLen = N.length();

        List<Integer> result = new ArrayList<>();
        List<Integer> pi = getPartialMatch(N);
        int begin = 0;
        int matched = 0;

        while (begin <= hLen - nLen) {
            if (matched < nLen && H.charAt(begin + matched) == N.charAt(matched)) {
                ++matched;
                if (matched == nLen) result.add(begin);
            } else {
                begin += matched - pi.get(matched - 1);
                matched = pi.get(matched - 1);
            }
        }

        return result;
    }

    private List<Integer> getPartialMatch(String str) {
        return null;
    }
}
