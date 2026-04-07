package _06_Backtracking.BJ9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 크기가 N * N 체스판에서 퀸 N개를 서로 공격할 수 없게 놓기
 * -퀸은 수직, 대각선상으로 공격가능
 *
 *
 *
 * */
public class Main {
    static int N;
    static int[] cols; // 1차원 배열로 체스판 상태 관리 (index: 행, value: 열)
    static int ans = 0; // 가능한 경우의 수 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cols = new int[N];

        // 0번째 행부터 퀸을 놓기 시작
        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int row) {
        // [종료 조건] 모든 행(N개)에 퀸을 다 놓았을 때
        if (row == N) {
            ans++;
            return;
        }

        // 현재 행(row)에서 모든 열(col)을 순회하며 퀸을 놓아봄
        for (int col = 0; col < N; col++) {
            cols[row] = col; // 일단 퀸을 놓음

            // [가지치기] 방금 놓은 퀸이 유망한지 확인
            if (isPromising(row)) {
                dfs(row + 1); // 유망하다면 다음 행으로 진행
            }
            // 유망하지 않다면 다음 col로 넘어가며 자연스럽게 백트래킹 발생
        }
    }

    static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            // 1. 같은 열에 있는지 체크
            if (cols[i] == cols[row]) {
                return false;
            }

            // 2. 대각선에 있는지 체크 (행의 차이 == 열의 차이)
            // Math.abs를 통해 기울기가 1 혹은 -1인 지점을 필터링
            if (Math.abs(row - i) == Math.abs(cols[row] - cols[i])) {
                return false;
            }
        }
        return true;
    }
}