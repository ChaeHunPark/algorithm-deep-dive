package _06_Backtracking.BJ14888_연산자_끼워넣기;


import java.io.BufferedReader;

/**
 * 첫째 줄 수의 갯수 N(2 <= N <= 11)
 * 둘째 줄 a[0], a[2] ... A[N]
 * 셋째 줄 합이 N-1인 4개의 정수, 차례대로 +, -, *, /의 갯수
 *
 * */

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static int[] operators = new int[4];

    // 최댓값은 최소로, 최솟값은 최대로 설정
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력 (+, -, *, / 순서)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // DFS 시작: (첫 번째 숫자, 다음 숫자의 인덱스)
        _14888_dfs(numbers[0], 1);

        System.out.println(maxValue + "\n" + minValue);
    }

    private static void _14888_dfs(int num, int idx) {
        // 1. 모든 숫자를 다 사용했을 때 (종료)
        if (idx == n) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return; // 반드시 return 해줘야 함!
        }

        // 2. 4종류 연산자 하나씩 시도
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산자 사용

                if (i == 0) _14888_dfs(num + numbers[idx], idx + 1);
                else if (i == 1) _14888_dfs(num - numbers[idx], idx + 1);
                else if (i == 2) _14888_dfs(num * numbers[idx], idx + 1);
                else if (i == 3) _14888_dfs(num / numbers[idx], idx + 1);

                operators[i]++; // 백트래킹 (원상복구)
            }
        }
    }
}
