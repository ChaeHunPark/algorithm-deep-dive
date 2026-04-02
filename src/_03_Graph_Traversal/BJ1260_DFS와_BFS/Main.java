package _03_Graph_Traversal.BJ1260_DFS와_BFS;

import java.io.BufferedReader;

/**
 * 정점의 갯수 N(1 <= N <= 1,000)
 * 간선의 갯수 M(1 <= M <= 10,000)
 * 탐색의 시작할 정점의 번호 V
 * 입력으로 주어지는 간선은 양방향
 * */

import java.util.*;
import java.io.*;

public class Main {
    static int n; // 정점의 갯수
    static int m; // 간선의 갯수
    static int v; // 시작할 정점의 번호
    static boolean[] visited; // 방문 여부
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1]; // 0은 입력되지 않음.

        // 정점 n개 만큼 만들기.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }


        // 간선 잇기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int edge1 = Integer.parseInt(st.nextToken());
            int edge2 = Integer.parseInt(st.nextToken());

            adj.get(edge1).add(edge2);
            adj.get(edge2).add(edge1);

        }

        // 모든 인접 리스트를 오름차순으로 정렬 (작은 번호부터 가기 위함)
        for (int i = 1; i <= n; i++) {
            Collections.sort(adj.get(i));
        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);


    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        // bfs는 넣을 때 방문처리.
        // 큐에 들어있는 노드가 아직 poll 되지 않았다면 visited가 false.
        // 다른 노드에서  똑같은 노드를 중복해서 큐에 또 넣는 참사 발생.
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");

            List<Integer> list = adj.get(v);
            for (int next : list) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }
    }


    static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        // dfs는 꺼낼때 방문처리.
        for (int next : adj.get(start)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

}
