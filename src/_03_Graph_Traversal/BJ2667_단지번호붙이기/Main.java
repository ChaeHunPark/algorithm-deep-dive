package _03_Graph_Traversal.BJ2667_단지번호붙이기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int n; // 지도의 크기
    static int[][] map; // 2. 단지를 담을 배열
    static boolean[][] visited; // 3. 방문 여부 체크 배열
    static int totalComplexCount = 0; // 1. 총 단지 갯수
    static ArrayList<Integer> complexSizeList = new ArrayList<>(); // 4. 단지별 집 갯수 리스트
    static StringBuilder sb = new StringBuilder();
    // 상 하 좌 우
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 지도의 크기

        map = new int[n][n]; // 지도 크기 지정
        visited = new boolean[n][n];

        // 지도 입력받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 새 단지의 시작점을 찾은 경우
                if (map[i][j] == 1 && !visited[i][j]) {
                    totalComplexCount++; // 1. 총 단지 수 증가
                    int houseCount = dfs(i, j); // 2. DFS를 돌며 집 갯수를 반환받음
                    complexSizeList.add(houseCount); // 3. 리스트에 저장
                }
            }
        }

        Collections.sort(complexSizeList);
        sb.append(totalComplexCount).append("\n");

        for (int list : complexSizeList) {
            sb.append(list).append("\n");
        }

        System.out.println(sb);


    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1; // 현재 방문한 집 1개부터 시작

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k]; //

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    // 연결된 집들의 개수를 모두 더함
                    count += dfs(nx, ny);
                }
            }
        }
        return count; // 이 단지의 총 집 갯수 반환
    }
}