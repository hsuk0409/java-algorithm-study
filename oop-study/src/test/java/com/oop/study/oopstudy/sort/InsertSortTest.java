package com.oop.study.oopstudy.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class InsertSortTest {

    @Test
    @DisplayName("삽입정렬 구현해보기")
    void sortInsertTest() {
        int[] arr = new int[] { 4, 5, 11, 2, 1 };

        assertThat(arr[0]).isEqualTo(4);
        sortInsert(arr);
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[arr.length - 1]).isEqualTo(11);
    }

    private void sortInsert(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int sd = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > sd) {
                arr[prev + 1] = arr[prev];
                --prev;
            }
            arr[prev + 1] = sd;
        }
    }
}
