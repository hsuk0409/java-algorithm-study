package com.oop.study.oopstudy.graph2;

public final class Candidate implements Comparable<Candidate> {
    private final Node node;
    private final int distance;

    public Candidate(final Node node, final int distance) {
        this.node = node;
        this.distance = distance;
    }

    public Node getNode() {
        return this.node;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Candidate o) {
        return this.getDistance() - o.distance;
    }
}