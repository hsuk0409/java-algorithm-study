package com.oop.study.oopstudy.sort.quick;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class MyQuickSort2Test {

    @DisplayName("퀵 정렬 두번째 구현해보기")
    @Test
    public void sortQuickSecondsTest() {
        int[] arr = new int[] { 5, 8, 4, 5, 11, 2, 13, 1 };

        myQuickSortRecursive(arr, 0, arr.length - 1);
    }

    private void myQuickSortRecursive(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotPos = partition(arr, left, right);

        // Left Sort
        myQuickSortRecursive(arr, left, pivotPos - 1);

        // Right Sort
        myQuickSortRecursive(arr, pivotPos + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];

        int swapIndex = (left - 1);
        for (int i = left; i < right; ++i) {
            if (arr[i] < pivot) {
                ++swapIndex;
                swap(arr, swapIndex, i);
            }
        }
        int pivotPos = (swapIndex + 1);
        swap(arr, pivotPos, right);

        return pivotPos;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
