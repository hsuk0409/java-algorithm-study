package com.oop.study.oopstudy.sort.quick;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuickSort4Test {
    @DisplayName("210923 퀵소트 연습")
    @Test
    void test() {
        int[] nums = new int[] {8, 2, 5, 4, 6, 3, 12, 0};
        int[] result = new int[] {0, 2, 3, 4, 5, 6, 8, 12};

        quickSortRecursive(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; ++i) {
            assert (nums[i] == result[i]);
        }
    }

    private void quickSortRecursive(int[] nums, int l, int r) {
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
