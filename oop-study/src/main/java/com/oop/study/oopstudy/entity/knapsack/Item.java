package com.oop.study.oopstudy.entity.knapsack;

public class Item {
    private final int value;
    private final int space;

    public Item(final int value, final int space) {
        this.value = value;
        this.space = space;
    }

    public int getValue(){
        return this.value;
    }

    public int getSpace() {
        return this.space;
    }
}
