package _07_Shortest_Path.BJ1916_최소비용_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  - N개의 도시가 있음
 *  - 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있음
 *  - A도시에서 B도시 까지 가는 드는 최소비용 출력
 *
 *  도시의 갯수 N (1 <= N <= 1000)
 *  버스의 개수 M (1 <= 100000)-
 *
 * */


public class Main {
    static ArrayList<Node>[] graph;
    static int n, m; // 도시의 수, 버스의 수
    static int[] dist;

    final static int INF = 100_000_000;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine()); // 도시의 수
        m = Integer.parseInt(br.readLine()); // 버스의 수

        dist = new int[n+1];
        graph = new ArrayList[n+1];

        // 그래프 추가
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 추가
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[startCity].add(new Node(endCity,weight));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }
    static void dijkstra(int start) {
        //1. dist 초기화
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int curIdx = current.target;
            int curWeight = current.weight;

            if(dist[curIdx] < curWeight) continue;

            for (Node next : graph[curIdx]) {
                if(dist[next.target] > dist[curIdx] + next.weight) {
                    dist[next.target] = dist[curIdx] + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }
        }
    }

}

class Node implements Comparable<Node> {
    int target;
    int weight;

    public Node(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
