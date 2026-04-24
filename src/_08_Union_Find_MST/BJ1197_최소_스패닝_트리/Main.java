package _08_Union_Find_MST.BJ1197_최소_스패닝_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.cost, edge.cost);
    }
}

public class Main {
    static int[] parent;
    static int v, e; // 정점의 수, 간선의 수
    static int a, b, c; // 정점 a, 정점 b, 가중치 c

    static int mstCost, edgeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        List<Edge> edges = new ArrayList<>();



        // 정점의 수 간선의 수 입력 받기
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // parent 초기화
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        mstCost = 0;
        edgeCount = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);


        for (Edge edge : edges) {
            if(find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                mstCost += edge.cost;
                edgeCount++;

                if(edgeCount == v-1) break;
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
