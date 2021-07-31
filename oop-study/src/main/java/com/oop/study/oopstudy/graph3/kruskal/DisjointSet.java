package com.oop.study.oopstudy.graph3.kruskal;

import java.util.HashMap;

public final class DisjointSet {
    private class SetNode {
        private String parent;
        private int size;

        public SetNode(final String parent, final int size) {
            this.parent = parent;
            this.size = size;
        }
    }

    private final HashMap<String, SetNode> sets = new HashMap<>(64);

    // 각 노드마다 집합 생성
    public DisjointSet(final String[] nodes) {
        for (String s : nodes) {
            SetNode setNode = new SetNode(s, 1);
            this.sets.put(s, setNode);
        }
    }

    // 해당 노드가 속해있는 루트를 반환
    public String find(final String node) {
        assert (this.sets.containsKey(node));

        SetNode n = this.sets.get(node);
        String parent = n.parent;
        if (parent.equals(node)) {
            return node;
        }

        n.parent = find(n.parent);

        return n.parent;
    }

    // 두 노드가 속해있는 집합을 합친다.
    public void union(final String node1, final String node2) {
        assert (this.sets.containsKey(node1));
        assert (this.sets.containsKey(node2));

        String root1 = find(node1);
        String root2 = find(node2);

        if (root1.equals(root2)) {
            return;
        }

        SetNode parent = this.sets.get(root1);
        SetNode child = this.sets.get(root2);

        if (parent.size < child.size) {
            SetNode temp = parent;
            parent = child;
            child = temp;
        }

        // 트리가 너무 높아지는 것을 방지할 수 있음
        child.parent = parent.parent;
        parent.size = child.size + parent.size;
    }
}