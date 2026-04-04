package _05_Greedy.BJ11047_동전_0;
/**
 * 첫째 줄 N과 K 1<= N 10, 1 <= K <= 100,000,000
 * 둘째 줄 부터 N개의 줄에 동전의 가치 A_i가 오름차순으로 주어짐
 * 1 <= A_i <= 1,000,000, A_1 = 1, i>=2 인경우 A_i는 A_i-1의 배수
 *
 * 배수면 그리디 적용가능.
 * N은 최대 10 한바퀴만 돌면됨
 * O(N)
 * */

import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int count;
    static int[] moneyArr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n과 k 입력 받기
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        moneyArr = new int[n];

        // moneyArr에 단위 넣기
        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            moneyArr[i] = money;
        }

        // 오름차순으로 입력 받았으므로
        // 거꾸로 순환
        for (int i = n-1; i >= 0 ; i--) {
            // k보다 단위가 작거나 같으면
            if(moneyArr[i] <= k) {

                count += (k / moneyArr[i]);
                k %= moneyArr[i];
            }
        }
        System.out.println(count);

    }
}
