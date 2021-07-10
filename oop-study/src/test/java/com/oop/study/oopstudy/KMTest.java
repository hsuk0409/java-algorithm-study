package com.oop.study.oopstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class KMTest {
    @Test
    void test1() {
        String s = getFormattedNumber("1112224123");
        String s2 = getFormattedNumber("00-44  48 5555 8361");
        String s3 = getFormattedNumber("0 - 22 1985--324");
        String s4 = getFormattedNumber("555372654");

        assertThat(s, is("111-222-41-23"));
        assertThat(s2, is("004-448-555-583-61"));
    }

    private String getFormattedNumber(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int numCount = 0;

        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] >= 48 && chars[i] <= 57) {
                list.add(chars[i]);
            }
        }

        int size = list.size();
        boolean isLast = false;
        for (int i = 0; i < list.size(); ++i) {
            char c = list.get(i);
            sb.append(c);
            ++numCount;
            --size;

            if (size == 3 && isLast) {
                ++numCount;
            }

            isLast = false;
            if (numCount > 2 && size != 0) {
                sb.append('-');
                numCount = 0;
                isLast = true;
            }
        }

        return sb.toString();
    }

    @Test
    void test2() {
        int[] T = new int[] {0, 0, 0, 0, 2, 3, 3};
    }

    @Test
    void test3() {
        int[] nums1 = new int[] {3, 2, 3, 2, 3};
        int[] nums2 = new int[] {7, -5, -5, -5, 7, -1, 7};

        int length = getSwitchingSliceLength(nums1);
        int length2 = getSwitchingSliceLength(nums2);

        assertThat(length, is(5));
        assertThat(length2, is(4));
    }

    private int getSwitchingSliceLength(int[] A) {
        int result = 2;

        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return 1;
        }

        int even = A[0];
        int odd = A[1];
        for (int i = 2; i < A.length; ++i) {
            if (i % 2 == 0) {
                if (even == A[i]) {
                    ++result;
                }
                even = A[i];
            } else {
                if (odd == A[i]) {
                    ++result;
                }
                odd = A[i];
            }
        }

        return result;
    }
}
