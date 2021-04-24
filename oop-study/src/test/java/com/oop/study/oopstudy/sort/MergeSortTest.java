package com.oop.study.oopstudy.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    @DisplayName("병합 정렬 구현해보기")
    @Test
    public void myMergeSortTest() {
        int[] src = new int[] {1, 9, 8, 5, 4, 2, 7, 6 };
        int[] tmp = new int[src.length];

        sortMergeRecursive(src, tmp, 0, src.length - 1);

        assertThat(src[src.length - 1]).isEqualTo(9);
    }

    private void sortMergeRecursive(int[] src, int[] tmp, int s, int e) {
        if (s < e) {
            int mid = (s + e) / 2;
            sortMergeRecursive(src, tmp, s, mid);
            sortMergeRecursive(src, tmp, mid + 1, e);

            int p = s;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= e) {
                if (q > e || (p <= mid && src[p] < src[q])) {
                    tmp[idx++] = src[p++];
                } else {
                    tmp[idx++] = src[q++];
                }
            }

            for (int i = s; i <= e; ++i) {
                src[i] = tmp[i];
            }
        }
    }
}
