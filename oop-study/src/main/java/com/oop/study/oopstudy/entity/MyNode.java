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
    public MyNode(int data, MyNode left, MyNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void updateLeftNode(MyNode newNode) {
        this.left = newNode;
    }

    public void updateRightNode(MyNode newNode) {
        this.right = newNode;
    }
}
