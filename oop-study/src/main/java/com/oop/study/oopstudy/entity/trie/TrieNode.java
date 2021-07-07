package com.oop.study.oopstudy.entity.trie;

public class TrieNode {
    private TrieNode[] childes;
    private char data;
    private boolean isLast;

    public TrieNode(char data) {
        this.childes = new TrieNode[26];
        this.data = data;
        this.isLast = false;
    }

    public void addChildes(String word, int i) {
        if (word.length() <= i) {
            this.isLast = true;
            return;
        }

        char target = word.charAt(i++);
        int curIndex = target - 'a';

        if (this.childes[curIndex] != null) {
            this.childes[curIndex].addChildes(word, i);
            return;
        }

        TrieNode node = new TrieNode(target);
        this.childes[curIndex] = node;
        node.addChildes(word, i);
    }

    public char getData() {
        return this.data;
    }

    public boolean getIsLast() {
        return this.isLast;
    }

    public TrieNode[] getChildes() {
        return this.childes;
    }
}
