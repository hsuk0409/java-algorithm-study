package com.oop.study.oopstudy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Stack;

@Getter
@NoArgsConstructor
public class BinaryNode {
    private int data;
    private BinaryNode left;
    private BinaryNode right;

    @Builder
    public BinaryNode(int data) {
        this.data = data;
    }

    public BinaryNode insertRecursive(final BinaryNode node, int data) {
        if (node == null) {
            return BinaryNode.builder().data(data).build();
        }
        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    public BinaryNode getNodeOrNull(final BinaryNode node, int data) {
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
        BinaryNode toRemoveNode = getNodeOrNull(this, data);
        if (toRemoveNode != null) {
            BinaryNode predecessor = toRemoveNode;
            if (toRemoveNode.left != null) {
                BinaryNode left = toRemoveNode.left;
                while (left.right != null) {
                    predecessor = left;
                    left = left.right;
                }
                toRemoveNode.data = predecessor.right.data;
                predecessor.right = null;
            }
        }
    }

    public void traverseInOrderRecursive(BinaryNode node) {
        if (node == null) {
            return;
        }

        traverseInOrderRecursive(node.left);
        System.out.println(node.data);
        traverseInOrderRecursive(node.right);
    }

    public void traversePreOrderRecursive(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        traversePreOrderRecursive(node.left);
        traversePreOrderRecursive(node.right);
    }

    public void traversePreOrder(final BinaryNode node) {
        if (node == null) {
            return;
        }

        Stack<BinaryNode> nodes = new Stack<>();
        nodes.push(node);

        while (!nodes.empty()) {
            BinaryNode binaryNode = nodes.pop();

            System.out.println(binaryNode.data);

            if (binaryNode.right != null) {
                nodes.push(binaryNode.right);
            }

            if (binaryNode.left != null) {
                nodes.push(binaryNode.left);
            }
        }
    }
}
