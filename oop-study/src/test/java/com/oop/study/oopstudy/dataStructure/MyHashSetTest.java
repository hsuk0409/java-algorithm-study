package com.oop.study.oopstudy.dataStructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MyHashSetTest {
    @DisplayName("해시셋 사용해보기")
    @Test
    void testHashSet() {
        //given
        Set<Long> set = new HashSet<>();

        //when
        set.add(1L);
        set.add(1L);
        set.add(1L);
        set.add(1L);

        //then
        assertThat(set.size()).isEqualTo(1);
    }
}
