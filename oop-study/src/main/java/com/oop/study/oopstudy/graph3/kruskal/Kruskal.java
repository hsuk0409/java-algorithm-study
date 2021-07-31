package com.oop.study.oopstudy.graph3.kruskal;

import java.util.ArrayList;
import java.util.Arrays;

public final class Kruskal {
    private Kruskal() {
    }

    public static ArrayList<Edge> run(final String[] nodes, final Edge[] edges) {
        DisjointSet set = new DisjointSet(nodes);

        ArrayList<Edge> mst = new ArrayList<>(edges.length);

        Arrays.sort(edges);

        for (Edge edge : edges) {
            String n1 = edge.getNode1();
            String n2 = edge.getNode2();

            String root1 = set.find(n1);
            String root2 = set.find(n2);

            // 같은 집합 소속이 아니라면 변을 추가하고 노드들을 합친다.
            if (!root1.equals(root2)) {
                mst.add(edge);
                set.union(n1, n2);
            }
        }

        return mst;
    }
}