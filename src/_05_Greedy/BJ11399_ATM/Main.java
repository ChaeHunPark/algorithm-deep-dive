package _05_Greedy.BJ11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ATM.
 *
 *  - ATM은 1대
 *  - ATM 앞에 N명이 줄 서있음.
 *  - 1번부터 N번까지 번호가 있음
 *  - i번 사람이 돈을 인출하는 걸리는 시간 = p[i]
 *  - [3, 1, 3, 4, 5] 순서로 뽑는 경우
 *   a. 1번 사람 = 3분
 *   b. 2번 사람 = 1번 사람 만큼 기다림 3+1분
 *   c. 정리 = (3) + (3+1) + (3+1+3) + (3+1+3+4) + (3+1+3+4+5)
 *
 *
 *   solve
 *   - 오름차순 정렬 후 합산.
 *
 *   - 우선순위 큐 vs 배열 -> sort
 *   - 데이터가 고정되어 한번에 들어오면 배열이 효율성이 좋고
 *   - 데이터가 하나씩들어오면 Priolyti가 좋음
 * */

public class Main {
    static int n;
    static int[] peoples;
    static int result;

    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        peoples = new int[n];

        // 입력받기

        for (int i = 0; i < n; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(peoples);

        result += peoples[0];

        // 각 걸리는 시간을 사람마다 갱신해서 누적합 구하기
        for (int i = 1; i < n; i++) {
            peoples[i] += peoples[i-1];
            result += peoples[i];
        }

        System.out.println(result);



    }
}
