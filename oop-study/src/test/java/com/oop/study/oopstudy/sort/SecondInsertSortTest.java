package com.oop.study.oopstudy.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SecondInsertSortTest {
    @DisplayName("삽입정렬 구현 연습")
    @Test
    void test() {
        int[] arr = {5, 2, 3, 3, 1, 4};

        insertSort(arr);
        assert (arr[0] == 1);
        assert (arr[1] == 2);
        assert (arr[2] == 3);
    }

    private void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            for (int k = i; k > 0; --k) {
                if (arr[k] < arr[k - 1]) {
                    int tmp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = tmp;
                }
            }
        }
    }
}
