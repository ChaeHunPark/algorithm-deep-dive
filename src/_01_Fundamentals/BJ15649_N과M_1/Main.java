package _01_Fundamentals.BJ15649_N과M_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * State Spzce Tree 필요.
 * N은 숫자의 갯수.
 * M은 숫자의 깊이라고 생각하기.
 * 4의 2가 입력되면
 * 1 2, 1 3, 1 4, 2 1, 2 3, 3 1, 3 2 .....
 *
 * bfs로 구현하고
 * 숫자가 전부 만족하면 출력 후, backTracking
 *
 *
 * */

public class Main {
    static int N, M;
    static int[] array;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자의 갯수.
        N = Integer.parseInt(st.nextToken());
        // 숫자의 깊이.
        M = Integer.parseInt(st.nextToken());

        // 방문 및 방문 초기화용, +1은 인덱스0은 사용하지 않는다.
        visited = new boolean[N+1];
        // 깊이가 만족하면 출력하기.
        array = new int[N];

        // 재귀적으로 깊이를 더하고 backtracking으로 탈출 시도
        dfs(0);

        System.out.println(sb);

    }

    static void dfs(int depth) {
        // 깊이가 만족하면? 출력하고 리턴
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 깊이가 만족하면? 백트래킹해서 경우의수를 모두 들린다.
        for (int i = 1; i <= N; i ++) {
            // 아직 방문하지 않았다면?
            if(!visited[i]) {
                visited[i] = true;
                array[depth] = i;
                dfs(depth +1); // ★ 핵심: 현재 깊이(순서)에 숫자를 저장
                visited[i] = false;
            }
            // 방문을 마쳤으면 backtracking해서 방문하지 않은 부분을 찾는다. for문은 아직 끝나지 않음.


        }


    }
}
