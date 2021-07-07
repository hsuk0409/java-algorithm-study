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
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TrieNode thisNode = stack.pop();
            System.out.println("Data: " + thisNode.getData());
            System.out.println("Is Last?: " + thisNode.getIsLast());

            for (TrieNode tmp : thisNode.getChildes()) {
                if (tmp != null) {
                    stack.push(tmp);
                }
            }
        }
    }
}
