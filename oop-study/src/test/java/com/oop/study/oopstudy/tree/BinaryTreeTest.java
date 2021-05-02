package com.oop.study.oopstudy.tree;

import com.oop.study.oopstudy.entity.MyNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

    @DisplayName("이진 트리 저장 호출")
    @Test
    void binarySearchTreeTest() {
        //given
        MyNode node = MyNode.builder().data(6).build();

        //when
        saveTree(node, 2);
        saveTree(node, 11);
        saveTree(node, 3);
        saveTree(node, 7);
        saveTree(node, 5);

        //then
        assertThat(node.getLeft().getData()).isEqualTo(2);
        assertThat(node.getRight().getData()).isEqualTo(11);
    }

    void saveTree(MyNode node, int data) {
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
                saveTree(left, data);
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
                saveTree(right, data);
            }
        }
    }
}
