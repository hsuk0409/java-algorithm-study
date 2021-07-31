package com.oop.study.oopstudy.graph3.kruskal;

public final class Edge implements Comparable<Edge> {
    private final String node1;
    private final String node2;
    private final int weight;

    public Edge(final String node1, final String node2, final int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public String getNode1() {
        return this.node1;
    }

    public String getNode2() {
        return this.node2;
    }

    public int getWeight() {
        return this.weight;
    }

    // 가중치 순으로 변을 정렬
    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}