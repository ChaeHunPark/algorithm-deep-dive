package _08_Union_Find_MST.Template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1. 간선(Edge) 정보를 저장하는 표준 클래스
class Edge implements Comparable<Edge> {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        // 오름차순 정렬 (최소 비용 우선)
        return Integer.compare(this.cost, other.cost);
    }
}

public class KruskalTemplate {
    static int[] parent;

    public static void main(String[] args) {
        // v(정점 수), e (간선 수)
        int v = 7;
        List<Edge> edges = new ArrayList<>();


        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 2));



        // 가중치 기준 오름차순 정렬
        Collections.sort(edges);

        // 부모 배열 초기화
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        long mstCost = 0; // 최소 비용 합계
        int edgeCount = 0; // 연결된 간선 수

        // 크루스칼 핵심 로직
        for(Edge edge : edges) {
            // 사이클이 발생하지 않는 경우에만 선택
            if(find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                mstCost += edge.cost;
                edgeCount++;

                // 모든 정점을 연결(V-1개의 간선)하면 조기 종료
                if(edgeCount == v - 1) break;

            }
        }

        System.out.println(mstCost);

    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }

    }
}
