package com.oop.study.oopstudy.entity.trie;

import java.util.Stack;

public class Trie {
    private TrieNode root;

    public Trie(String[] words) {
        this.root = new TrieNode('\0');
        for (String word : words) {
            this.root.addChildes(word, 0);
        }
    }


    public void searchDepthFirst() {
        this.root.searchDfs();
    }

    public void searchBreadthFirst() {
        this.root.searchBfs();
    }
}
