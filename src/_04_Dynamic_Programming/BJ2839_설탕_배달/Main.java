package _04_Dynamic_Programming.BJ2839_설탕_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        Arrays.fill(dp, INF);

        // 2. 기초 사실 적기
        dp[3] = 1;
        dp[5] = 1;

        // 3. 6kg 부터 수첩 채우기 시작
        for (int i = 6; i <= n; i++) {
            // i-3kg가 배달 가능한 무게라면
            if (dp[i - 3] != INF) {
                dp[i] = dp[i - 3] + 1; // 3kg 케이스에서 도출한값 1 + 나의 경우 3키로를 시도해보겠다는 1+ = 2
            }


            // i-5kg가 배달 가능한 무게라면
            if (dp[i - 5] != INF) {
                // 이미 3kg로 구한 값과 비교해서 더 작은 걸 선택
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
