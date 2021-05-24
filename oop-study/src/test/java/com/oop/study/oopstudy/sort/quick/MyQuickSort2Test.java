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

        printArr(arr);
        myQuickSortRecursive(arr, 0, arr.length - 1);
        printArr(arr);
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
        int swapIndex = left;
        for (int i = left; i < right; ++i) {
            if (arr[i] < arr[right]) {
                swap(arr, swapIndex, i);
                ++swapIndex;
            }
        }
        swap(arr, swapIndex, right);

        return swapIndex;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
