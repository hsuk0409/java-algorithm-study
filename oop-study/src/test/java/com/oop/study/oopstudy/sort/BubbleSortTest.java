package com.oop.study.oopstudy.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BubbleSortTest {

    @DisplayName("오름차순 버블 정렬")
    @Test
    void bubbleSortTestAsc() {
        int[] arr = new int[]{ 6, 5, 11, 2, 3, 1, 16 };

        bubbleSort(arr);
        assertThat(arr[0]).isEqualTo(1);
    }

    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
