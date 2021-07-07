package com.oop.study.oopstudy.entity.trie;

public class Trie {
    private TrieNode root;

    public Trie(String word) {
        this.root = new TrieNode('\0');
        this.root.addChildes(word, 0);
    }

    public void searchDepthFirst() {
        root.searchDepthFirst();
    }
}
