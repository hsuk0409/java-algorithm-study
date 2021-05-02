package com.oop.study.oopstudy.tree;

import com.oop.study.oopstudy.entity.MyNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    @DisplayName("이진 탐색 트리 저장")
    @Test
    void bstSaveTest() {
        //given
        MyNode node = MyNode.builder().data(6).build();

        //when
        node.insertRecursive(node, 2);
        node.insertRecursive(node, 11);
        node.insertRecursive(node, 15);
        node.insertRecursive(node, 3);
        node.insertRecursive(node, 5);

        //then
        // left
        assertThat(node.getLeft().getData()).isEqualTo(2);
        assertThat(node.getLeft().getRight().getData()).isEqualTo(3);
        assertThat(node.getLeft().getRight().getRight().getData()).isEqualTo(5);

        // right
        assertThat(node.getRight().getData()).isEqualTo(11);
        assertThat(node.getRight().getRight().getData()).isEqualTo(15);
    }

    @DisplayName("이진 탐색 트리 탐색")
    @Test
    void bstSearchTest() {
        //given
        MyNode node = MyNode.builder().data(6).build();
        node.insertRecursive(node, 2);
        node.insertRecursive(node, 11);
        node.insertRecursive(node, 15);
        node.insertRecursive(node, 3);
        node.insertRecursive(node, 5);

        //when
        MyNode nodeFound = node.getNodeOrNull(node, 11);

        //then
        assertThat(nodeFound.getData()).isEqualTo(node.getRight().getData());
    }
}
