package com.oop.study.oopstudy.sort.quick;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class QuickSort2Test {

    @DisplayName("210712 퀵소트 만들어보기")
    @Test
    void test() {
        int[] nums = new int[] {4, 9, 2, 11, 15, 1, 8};

        quickSortRecursive(nums, 0, nums.length - 1);

        assertThat(nums[0], is(1));
    }

    private void quickSortRecursive(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);

            quickSortRecursive(nums, l, pivot - 1);
            quickSortRecursive(nums, pivot + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int standard = l;

        for (int i = standard; i < r; ++i) {
            if (nums[i] < nums[r]) {
                swap(nums, standard, i);
                ++standard;
            }
        }

        swap(nums, standard, r);

        return standard;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
