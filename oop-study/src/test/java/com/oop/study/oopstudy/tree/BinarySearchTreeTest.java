package com.oop.study.oopstudy.tree;

import com.oop.study.oopstudy.entity.MyNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    @DisplayName("이진 탐색 트리 저장 호출")
    @Test
    void binarySearchTreeTest() {
        //given
        MyNode node = MyNode.builder().data(6).build();

        //when
        saveBts(node, 2);
        saveBts(node, 11);
        saveBts(node, 3);
        saveBts(node, 7);
        saveBts(node, 5);

        //then
        assertThat(node.getLeft().getData()).isEqualTo(2);
        assertThat(node.getRight().getData()).isEqualTo(11);
    }

    void saveBts(MyNode node, int data) {
        if (node == null) {
           return;
        }
        int nodeData = node.getData();
        if (nodeData >= data) {
            MyNode left = node.getLeft();
            if (left == null) {
                MyNode newNode = MyNode.builder()
                        .data(data)
                        .build();
                node.updateLeftNode(newNode);
                return;
            } else {
                saveBts(left, data);
            }
        } else if (nodeData < data) {
            MyNode right = node.getRight();
            if (right == null) {
                MyNode newNode = MyNode.builder()
                        .data(data)
                        .build();
                node.updateRightNode(newNode);
                return;
            } else {
                saveBts(right, data);
            }
        }
    }
}
