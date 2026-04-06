package _05_Greedy.BJ1931_회의실_배정;


/**
 * 회의실 배정.
 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대 개수 찾기
 * 1. 회의는 한번 시작하면 중단하지 않음
 * 2. 한 회의가 끝나는 것 동시에 다음 회의가 시작 될수 있음
 *
 *  회의의 수 N(1 <= 100,000)
 *  둘째 줄 부터 N+1 줄까지 각 회의의 정보 ( 시작시간과 끝나느 시간)
 *  1초 -> O(N log N) + O(N)으로 해결
 *  그리디
 * */

import java.io.*;
import java.util.*;

public class Main {

    static int time[][]; // 시간이 담겨있는 배열
    static int n; // 회의의 수
    static int count = 0;
    static int prev_end_time = 0; // 직전 회의가 끝난 시간을 저장하는 변수
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        time = new int[n][2];


        // 시간 입력 받기.
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // Sorting
        sort(time);
        // counting
        solved(time);
        // output
        System.out.println(count);


    }

    private static void solved(int[][] array) {
        for (int i = 0; i < n; i++) {
            // 현재 회의의 시작 시간이 직전 회의의 종료 시간보다 크거나 같다면 (겹치지 않는다면)
            if (time[i][0] >= prev_end_time) {
                count++; // 회의 배정!
                prev_end_time = time[i][1]; // 이제 기준점은 현재 회의의 종료 시간으로 갱신
            }
        }
    }

    // 1. 끝나는 시간 기준으로 오름차순
    // 2. 끝나는 시간이 같다면? 시작 시간으로 오름차순
    static void sort(int[][] Array) {
        Arrays.sort(Array, (t1, t2) -> {
            if(t1[1] == t2[1]) {
                return t1[0] - t2[0];
            }
            return t1[1] - t2[1];
        });
    }
}
