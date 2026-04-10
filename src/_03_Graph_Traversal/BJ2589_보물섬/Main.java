package _03_Graph_Traversal.BJ2589_보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - 육지는 L, 바다는 W로 표시되어있음.
 * - 이동은 상하좌우로 이웃한 육지만 이동가능
 * - 한 칸 이동시 한 시간 걸림
 *
 * **보물은 서로 간에 최단 거리로 이동하는데 있어서 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻힘**
 * - 육지 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나 멀리 돌아가면 안됨(BFS로 visited true 처리해서 미리 경로를 닫는다.)
 *
 * 격자그래프 DFS
 * O(L *(V+E))
 *
 * 1. 격자 그래프 상태 입력 받기
 * 2. 그래프 순회 및 방문처리
 * 3. 가장 높은값 갱신
 * 4. 방문처리 했던거 되돌려놓기 -> new visited
 *
 * */

public class Main {
    static int L, M; // 육지, 바다
    static int n, m; // 가로 세로
    static char[][] map; // 지도
    static boolean[][] visited; // 방문 여부를 담는 배열
    static int maxValue = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        // 가로 세로의 길이 입력받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 지도 갱신
        map = new char[n][m];


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 그래프 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'L'){
                    visited = new boolean[n][m]; // 방문여부는 새 탐색마다 초기화
                    bfs(i,j);
                }
            }
        }

        System.out.println(maxValue);


    }

    public static void bfs(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[] {x,y, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            maxValue = Math.max(maxValue, current[2]);

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m ) {
                    // 다음 노드가 L 이면서 방문하지 않았으면
                    if (map[nx][ny] == 'L' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, current[2] + 1});
                    }
                }
            }
        }

    }

}
