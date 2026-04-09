package _03_Graph_Traversal.BJ1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t; // 테스트 케이스
    static int m; // 가로길이
    static int n; // 세로길이
    static int k; // 배추가 심어져 있는 위치의 개수

    static boolean[][] visited;
    static int[][] map;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int count = 0;

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            k = Integer.parseInt(st.nextToken()); // 배추 위치의 갯수

            map = new int[m][n];
            visited = new boolean[m][n];

            // 1. 배추 심기
            for (int i = 0; i < k; i++) {
               st = new StringTokenizer(br.readLine());
               int x = Integer.parseInt(st.nextToken());
               int y = Integer.parseInt(st.nextToken());
               map[x][y] = 1;
            }

            // 탐색
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // 배추가 있고 방문하지 않았다.
                    if(map[i][j] == 1 && !visited[i][j]) {
                        count++; // 카운팅
                        dfs(i,j);
                    }

                }
            }
            sb.append(count);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n ) {
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx,ny);
                }

            }

        }

    }

}
