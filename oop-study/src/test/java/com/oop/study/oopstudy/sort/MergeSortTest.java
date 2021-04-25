package com.oop.study.oopstudy.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    @DisplayName("병합 정렬 구현해보기")
    @Test
    public void myMergeSortTest() {
        int[] src = new int[] {1, 9, 8, 5, 4, 2, 7, 6 };
        printArr(src);
        mergeSortRecursive(src, 0, src.length - 1);
        printArr(src);
        assertThat(src[src.length - 1]).isEqualTo(9);
    }

    private void mergeSortRecursive(int[] src, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSortRecursive(src, l, mid);
            mergeSortRecursive(src, mid + 1, r);
            mergeSort(src, l, mid, r);
        }
    }

    private void mergeSort(int[] src, int l, int mid, int r) {
        int p = l;
        int q = mid + 1;
        int idx = p;
        int tmp[] = new int[src.length];

        while (p <= mid || q <= r) {
            if (q > r || (p <= mid && src[p] < src[q])) {
                tmp[idx++] = src[p++];
            } else {
                tmp[idx++] = src[q++];
            }
        }

        for (int i = l; i <= r; ++i) {
            src[i] = tmp[i];
        }
    }

    private void printArr(int[] src) {
        for (int i = 0; i < src.length; ++i) {
            System.out.print(src[i] + " ");
        }
        System.out.println();
    }
}
