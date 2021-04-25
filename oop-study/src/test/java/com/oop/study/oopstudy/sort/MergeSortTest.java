package com.oop.study.oopstudy.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    @DisplayName("병합 정렬 구현해보기")
    @Test
    public void myMergeSortTest() {
        int[] arr = new int[] {1, 9, 8, 5, 4, 2, 7, 6 };
        printArr(arr);
        mergeSortRecursive(arr, 0, arr.length - 1);
        printArr(arr);
        assertThat(arr[arr.length - 1]).isEqualTo(9);
    }

    private void mergeSortRecursive(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSortRecursive(arr, l, mid);
            mergeSortRecursive(arr, mid + 1, r);
            mergeSort(arr, l, mid, r);
        }
    }

    private void mergeSort(int[] arr, int l, int mid, int r) {
        int p = l;
        int q = mid + 1;
        int idx = p;
        int tmp[] = new int[arr.length];

        while (p <= mid || q <= r) {
            if (q > r || (p <= mid && arr[p] < arr[q])) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }

        for (int i = l; i <= r; ++i) {
            arr[i] = tmp[i];
        }
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
