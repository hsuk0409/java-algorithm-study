package com.oop.study.oopstudy.tree;

import com.oop.study.oopstudy.entity.trie.Trie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrieTest {

    @DisplayName("트라이에 데이터 저장 후 DFS")
    @Test
    void saveTrieTest() {
        //given
        final String[] word = { "justin", "justify" };

        //when
        Trie trie = new Trie(word);

        //then
        trie.searchDepthFirst();
    }
}
