package com.oop.study.oopstudy.sort.quick;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuickSort3Test {
    @DisplayName("210918 퀵정렬 구현 반복 연습")
    @Test
    void test() {
        int[] nums = new int[] {9, 2, 5, 4, 1, 12, 10};
        int[] result = new int[] {1, 2, 4, 5, 9, 10, 12};

        quickSortRecursive(nums, 0, nums.length - 1);

        for (int i = 0; i < result.length; ++i) {
            assert nums[i] == result[i];
        }
    }

    public void quickSortRecursive(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);

            quickSortRecursive(nums, l, pivot - 1);
            quickSortRecursive(nums, pivot + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = l;

        for (int i = pivot; i < r; ++i) {
            if (nums[i] < nums[r]) {
                int tmp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = tmp;
                ++pivot;
            }
        }

        int tmp = nums[pivot];
        nums[pivot] = nums[r];
        nums[r] = tmp;

        return pivot;
    }
}