package com.oop.study.oopstudy.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SelectSortTest {

    @DisplayName("오름차순 선책정렬")
    @Test
    void selectSortTest() {
        int[] arr = new int[]{ 4, 6, 11, 15, 2, 5, 1, 3 };

        sortSelectAsc(arr);
        assertThat(arr[0]).isEqualTo(1);
    }

    private void sortSelectAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = getIndexOfMinValue(arr, i);
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    @DisplayName("최소값의 인덱스 가져오기")
    @Test
    void testGetMinIndex() {
        int[] arr = new int[]{ 4, 6, 11, 15, 2, 5, 1, 3 };
        int minIndex = getIndexOfMinValue(arr, 0);

        assertThat(minIndex).isEqualTo(6);
    }

    private int getIndexOfMinValue(int[] arr, int start) {
        int ret = start;
        for (int i = start + 1; i < arr.length; ++i) {
            if (arr[ret] > arr[i]) {
                ret = i;
            }
         }
        return ret;
    }
}
