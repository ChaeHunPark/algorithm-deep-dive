package _07_Shortest_Path.BJ1753_최단경로;



import java.io.*;
import java.util.*;


public class Main {
    static List<Node>[] graph;
    static int V, E; // 정점의 개수, 간선의 개수
    static int start; // 시작 정점
    static int u,v,w; // u에서 v로 가는 가중치 w.
    static int dist[]; // 최단거리 저장소
    final static int INF = 100_000_000; // MAX_VALUE는 오버플로우 가능성 있음

    StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        dist = new int[V + 1];



        // 정점v 만큼 리스트 생성
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 연결
        for (int i = 0; i < E; i++) {
            // u, v, w가 순서 대로 주어짐
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(start);

        // 2. 결과 출력 (StringBuilder 권장)
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);

    }

    static void dijkstra(int start) {
        // dist 초기화
        Arrays.fill(dist, INF);

        // 시작은 가중치 0
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while (!pq.isEmpty()) {
            // 1. pq에서 꺼낸다.
            Node current = pq.poll();
            int currentIdx = current.target;
            int currentWeight = current.weight;

            // 이전에 저장한 dist값 보다 크몀 스킵.
            if(dist[currentIdx] < currentWeight) continue;

            // 현재 idx에서 탐색
            for(Node next : graph[currentIdx]) {
                if(dist[next.target] > dist[currentIdx] + next.weight) { // 저장 되어있는 다음의 가중치 > 현재 가중치 + 다음 가중치?
                    // 현재 가중치 + 다음 가중치를 갱신
                    dist[next.target] = dist[currentIdx] + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));

                }
            }

        }


    }
}


class Node implements Comparable<Node> {
    int target, weight;

    public Node(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    // 우선순위 큐에서 거리가 짧은 순으로 정렬하기 위해 필요
    @Override
    public int compareTo(Node o) {
        return this.weight- o.weight;
    }
}