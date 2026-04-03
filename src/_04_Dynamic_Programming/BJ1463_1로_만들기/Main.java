package _04_Dynamic_Programming.BJ1463_1로_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. DP 테이블 생성(n까지의 정답을 저장할 수첩)
        // 인덱스 숫자를 그대로 쓰기 위해 n + 1 크기로 만듬
        int[] dp = new int[n + 1];

        // 2. 초기값 설정
        // 숫자 1은 이미 1이므로 연산 횟수가 0이다.
        dp[1] = 0;

        // 3. 2부터 n까지 차례대로 최솟값을 구한다 (Bottom-Up)
        for (int i = 2; i <= n; i++){

            // i가 10이라고 가정
            // dp[10] = dp[10-1] + 1 -> dp[i] = 3
            dp[i] = dp[i-1] +1;


            // 3 과 dp[i/2] + 1중 뭐가 작은가?
            // dp[i/2] + 1 = dp[5] + 1 = 4
            // 3 과 4를 비교
            // dp[i] = 3

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

            // 3과 dp[i/3] + 1중 뭐가 작은가
            // 스킵

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }

        }

        System.out.println(dp[n]);
    }


}
