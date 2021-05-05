package com.oop.study.oopstudy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyNode {
    private int data;
    private MyNode left;
    private MyNode right;

    @Builder
    public MyNode(int data) {
        this.data = data;
    }

    public MyNode insertRecursive(final MyNode node, int data) {
        if (node == null) {
            return MyNode.builder().data(data).build();
        }
        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    public MyNode getNodeOrNull(final MyNode node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return node;
        }
        if (data < node.data) {
            return getNodeOrNull(node.left, data);
        } else {
            return getNodeOrNull(node.right, data);
        }
    }

    public void removeLeftMaxNode(int data) {
        MyNode toRemoveNode = getNodeOrNull(this, data);
        if (toRemoveNode != null) {
            MyNode predecessor = toRemoveNode;
            if (toRemoveNode.left != null) {
                MyNode left = toRemoveNode.left;
                while (left.right != null) {
                    predecessor = left;
                    left = left.right;
                }
                toRemoveNode.data = predecessor.right.data;
                predecessor.right = null;
            }
        }
    }

    public void traverseInOrder(MyNode node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.left);
        System.out.println(node.data);
        traverseInOrder(node.right);
    }

    public void traversePreOrder(MyNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }
}
