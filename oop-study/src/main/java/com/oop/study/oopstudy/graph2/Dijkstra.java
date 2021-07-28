package com.oop.study.oopstudy.graph2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public Dijkstra() {
    }

    public static HashMap<String, Integer> run(final HashMap<String, Node> nodes,
                                               final String from,
                                               final HashMap<String, String> prevs) {
        HashMap<String, Integer> minDists = new HashMap<>();

        // 각 노드까지의 최단 거리를 일단 무한으로 초기화
        final int INF = Integer.MAX_VALUE;
        for (var entry : nodes.entrySet()) {
            String name = entry.getKey();
            minDists.put(name, INF);
        }

        // 시작노드 0
        minDists.put(from, 0);

        // 선행노드는 없다.
        prevs.put(from, null);

        // 최단 경로일 가능성이 있는 경로들을 저장한다.
        PriorityQueue<Candidate> open = new PriorityQueue<>();

        Node s = nodes.get(from);
        Candidate candidate = new Candidate(s, 0);

        open.add(candidate);

        while (!open.isEmpty()) {
            candidate = open.poll();

            Node n = candidate.getNode();
            String nodeName = n.getName();

            int minDist = minDists.get(nodeName);
            int dist = candidate.getDistance();

            // 후보 경로의 거리가 현재까지 알려진 최단 거리보다 길다면 무시
            if (minDist < dist) continue;

            Map<Node, Integer> roads = n.getRoads();

            for (var e : roads.entrySet()) {
                Node next = e.getKey();

                int weight = e.getValue();
                int newDist = minDist + weight;

                String nextName = next.getName();
                int nextMinDist = minDists.get(nextName);

                if (newDist >= nextMinDist) continue;

                minDists.put(nextName, newDist);
                prevs.put(nextName, nodeName);

                Candidate newCandidate = new Candidate(next, newDist);

                open.add(newCandidate);
            }
        }

        return minDists;
    }
}
