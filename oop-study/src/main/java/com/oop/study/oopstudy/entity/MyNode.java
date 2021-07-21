package com.oop.study.oopstudy.entity;

public class MyNode {
    private int data;
    private MyNode right;
    private MyNode left;

    public MyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public MyNode getRight() {
        return this.right;
    }

    public MyNode getLeft() {
        return this.left;
    }

    public MyNode insertRecursive(MyNode node, int data) {
        if (node == null) {
            return new MyNode(data);
        }

        if (data >= node.data) {
            node.right = insertRecursive(node.right, data);
        } else {
            node.left = insertRecursive(node.left, data);
        }

        return node;
    }

    private MyNode getNodeOrNull(MyNode node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            return node;
        }

        if (node.data >= data) {
            return getNodeOrNull(node.left, data);
        } else {
            return getNodeOrNull(node.right, data);
        }
    }

    public void removeTreeToLeftMax(int removeData) {
        MyNode node = getNodeOrNull(this, removeData);
        if (node != null) {
            MyNode preNode = node;
            if (node.left != null) {
                MyNode leftMax = node.left;
                while (leftMax.right != null) {
                    preNode = leftMax;
                    leftMax = leftMax.right;
                }
                node.data = leftMax.data;
                preNode.right = null;
            } else {
                MyNode rightMax = node.right;
                while (rightMax.left != null) {
                    preNode = rightMax;
                    rightMax = rightMax.left;
                }
                node.data = rightMax.data;
                preNode.left = null;
            }
        }
    }
}
