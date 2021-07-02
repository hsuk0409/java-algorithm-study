package com.oop.study.oopstudy.tree;

import com.oop.study.oopstudy.entity.MyNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyNodeTreeTest {

    @DisplayName("트리 삽입 구현 연습")
    @Test
    void insertTreeTest() {
        //given
        MyNode node = new MyNode(14);

        //when
        MyNode myNode = node.insertRecursive(node, 5);

        //then
        assertThat(myNode.getData(), is(14));
        assertThat(myNode.getLeft().getData(), is(5));
    }

    @DisplayName("트리 삭제 구현 연습")
    @Test
    void removeTreeTest() {
        //given
        MyNode node = new MyNode(14);
        node.insertRecursive(node, 5);
        node.insertRecursive(node, 15);
        node.insertRecursive(node, 2);
        node.insertRecursive(node, 22);
        node.insertRecursive(node, 12);
        node.insertRecursive(node, 17);
        node.insertRecursive(node, 13);
        node.insertRecursive(node, 19);

        //when
        node.removeTreeToLeftMax(15);

        //then
        assertThat(node.getLeft().getData(), is(2));
    }
}
