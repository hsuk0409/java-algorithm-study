package com.oop.study.oopstudy.recursion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SearchRotateArrayTest {

    @Test
    @DisplayName("회전된 배열에서의 이진 탐색")
    public void searchRotateArray() {
        int[] array = new int[]{20, 25, 29, 33, 1, 3, 5, 6, 10, 11, 19};

        int index = indexOfRotateArray(array, 0, array.length - 1, 0);
        assertThat(index).isEqualTo(-1);

        index = indexOfRotateArray(array, 0, array.length - 1, 1);
        assertThat(index).isEqualTo(4);

        index = indexOfRotateArray(array, 0, array.length - 1, 29);
        assertThat(index).isEqualTo(2);
    }

    private int indexOfRotateArray(int[] array, int start, int end, int value) {
        if (start > end ) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == value) {
            return mid;
        }

        if (array[start] <= array[mid]) {
            log.info("Start value <= Mid value");
            if (value >= array[start] && value <= array[mid]) {
                log.info("The value is in the start end mid range.");
                return indexOfRotateArray(array, start, mid - 1, value);
            }

            return indexOfRotateArray(array, mid + 1, end, value);
        }

        if (value >= array[mid] && value <= array[end]) {
            log.info("value >= Mid value && value <= End value");
            return indexOfRotateArray(array, mid + 1, end, value);
        }

        return indexOfRotateArray(array, start, mid - 1, value);
    }
}
