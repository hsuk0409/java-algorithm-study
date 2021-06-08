package com.oop.study.oopstudy.tree;

import com.oop.study.oopstudy.entity.BinaryNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    @DisplayName("이진 탐색 트리 저장")
    @Test
    void bstSaveTest() {
        //given
        BinaryNode node = BinaryNode.builder().data(6).build();

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
        BinaryNode node = BinaryNode.builder().data(6).build();
        node.insertRecursive(node, 2);
        node.insertRecursive(node, 11);
        node.insertRecursive(node, 15);
        node.insertRecursive(node, 3);
        node.insertRecursive(node, 5);

        //when
        BinaryNode nodeFound = node.getNodeOrNull(node, 11);

        //then
        assertThat(nodeFound.getData()).isEqualTo(node.getRight().getData());
    }

    @DisplayName("이진 탐색 트리 삭제(왼쪽 하위 최댓값 사용)")
    @Test
    void bstRemoveTest() {
        //given
        BinaryNode node = BinaryNode.builder().data(6).build();
        node.insertRecursive(node, 2);
        node.insertRecursive(node, 11);
        node.insertRecursive(node, 15);
        node.insertRecursive(node, 3);
        node.insertRecursive(node, 5);

        //when
        node.removeLeftMaxNode(6);

        //then
        assertThat(node.getData()).isEqualTo(5);
    }

    @DisplayName("이진 탐색 트리 중위 순회하기")
    @Test
    void traverseInOderTest() {
        //given
        BinaryNode node = BinaryNode.builder().data(6).build();
        node.insertRecursive(node, 2);
        node.insertRecursive(node, 11);
        node.insertRecursive(node, 15);
        node.insertRecursive(node, 3);
        node.insertRecursive(node, 5);

        //when &then
        node.traverseInOrderRecursive(node);
    }

    @DisplayName("이진 탐색 트리 전위 순회하기")
    @Test
    void traversePreOderTest() {
        //given
        BinaryNode node = BinaryNode.builder().data(6).build();
        node.insertRecursive(node, 2);
        node.insertRecursive(node, 11);
        node.insertRecursive(node, 15);
        node.insertRecursive(node, 3);
        node.insertRecursive(node, 5);

        //when &then
        node.traversePreOrderRecursive(node);
        System.out.println("--------------------");
        node.traversePreOrder(node);
    }
}
