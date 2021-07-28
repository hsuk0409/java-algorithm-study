package com.oop.study.oopstudy.programmers.L1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryToStringTest {
    @DisplayName("1차 비밀지도 문제, 2진수 문자열 다루기")
    @Test
    void test() {
        int[] arr1 = new int[] {46, 33, 33 ,22, 31, 50};
        int[] arr2 = new int[] {27 ,56, 19, 14, 14, 10};
        String[] result = new String[] {"######", "### #", "## ##", " #### ", " #####", "### # "};

        String[] binaryStrMap = getBinaryStrMap(6, arr1, arr2);

        for (int i  = 0; i < binaryStrMap.length; ++i) {
            boolean equals = binaryStrMap[i].equals(result[i]);
            assert equals;
        }
    }

    public String[] getBinaryStrMap(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < arr1.length; ++i) {
            String binaryStr = Integer.toBinaryString(arr1[i] | arr2[i]);
            String tmp = "";

            int len = binaryStr.length();
            if (len < n) {
                int l = len;
                while (l < n) {
                    tmp += " ";
                    ++l;
                }
            }

            for (int k = 0; k < len; ++k) {
                if (binaryStr.charAt(k) == '1') tmp += "#";
                else tmp += " ";
            }
            result[i] = tmp;
        }

        return result;
    }
}
