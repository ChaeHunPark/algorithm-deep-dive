package _07_Shortest_Path.BJ11404_플로이드;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dist;
    // 경로가 없을 때의 최대값 설정 (노드 수 * 최대 가중치보다 커야 함)
    static final int INF = 10_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];

        // 1. 거리 배열 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // 2. 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 중복 노선 중 최소 비용만 저장 (핵심!)
            dist[u][v] = Math.min(dist[u][v], w);
        }

        // 3. 플로이드-워셜 알고리즘 (3중 for문)
        // 경유지(k) -> 출발지(i) -> 도착지(j) 순서 필수!
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // i에서 j로 가는 것보다 k를 거쳐가는 게 더 빠르면 갱신
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 여전히 INF라면 갈 수 없는 경로이므로 0 출력
                if (dist[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}