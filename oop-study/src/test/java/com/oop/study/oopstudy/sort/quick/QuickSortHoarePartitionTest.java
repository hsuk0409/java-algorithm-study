package com.oop.study.oopstudy.sort.quick;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuickSortHoarePartitionTest {

    @DisplayName("호어 분할법을 이용한 퀵 정렬")
    @Test
    public void quickSortHoarePartition() {
        int[] arr = new int[]{ 3, 1, 5, 7, 2, 9, 8, 4 };
        int[] arr2 = new int[]{ 1, 1, 1, 1, 1, 1, 1 };

        printArr(arr);
        quickSortRecursive(arr, 0, arr.length - 1);
        printArr(arr);

        printArr(arr2);
        quickSortRecursive(arr2, 0, arr2.length - 1);
        printArr(arr2);
    }

    private void quickSortRecursive(int[] arr, int l, int r) {
        if (l >= r) return;

        int pivotPos = partitionHoare(arr, l, r);

        quickSortRecursive(arr, l, pivotPos - 1);
        quickSortRecursive(arr, pivotPos + 1, r);
    }

    private int partitionHoare(int[] arr, int l, int r) {
        int pivot = arr[l];

        int i = l + 1;
        int j = r;
        while (i <= j) {
            while (i < r && arr[i] <= pivot) {
                ++i;
            }
            while (j > l && arr[j] >= pivot) {
                --j;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
