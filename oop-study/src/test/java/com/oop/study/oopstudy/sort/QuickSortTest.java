package com.oop.study.oopstudy.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class QuickSortTest {

    @DisplayName("퀵 정렬 구현해보기")
    @Test
    void quickSortTest() {
        int[] arr = new int[] { 7, 2, 5, 1, 3, 8, 7, 4, 9 ,6 };
        quicksortRecursive(arr, 0, arr.length - 1);

        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[arr.length - 1]).isEqualTo(9);
    }

    private void quicksortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(arr, left, right);

        quicksortRecursive(arr, left, pivotPos - 1);
        quicksortRecursive(arr, pivotPos + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];

        int i = (left - 1);
        for (int j = left; j < right; ++j) {
            if (arr[j] < pivot) {
                ++i;
                swap(arr, i, j);
            }
        }

        int pivotPos = i + 1;
        swap(arr, pivotPos, right);

        return pivotPos;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
