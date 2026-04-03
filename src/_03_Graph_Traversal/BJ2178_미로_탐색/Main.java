package _03_Graph_Traversal.BJ2178_미로_탐색;

import java.io.BufferedReader;

/**
 * 입력 N,M (2<= N, M <= 100)
 * 연산 100,000
 * */

import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int map[][]; //
    static boolean visited[][]; // 최단 거리가 먼저 도착하면 방문을 막음.
    static int result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 1. n과m 입력 받기
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 2. 방문 여부 및 지도 입력
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0,0);
        System.out.println(result);

    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()){
            // 큐에서 현재 좌표를 꺼내서 x, y에 담아야 함!
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            // 도착지에 도달했으면 바로 리턴
            if(x == n - 1 && y == m - 1) {
                return map[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 조건: nx는 n보다 작아야 하고, ny는 m보다 작아야 함
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        // 이전 칸의 거리 + 1을 새 칸에 저장
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }

}
