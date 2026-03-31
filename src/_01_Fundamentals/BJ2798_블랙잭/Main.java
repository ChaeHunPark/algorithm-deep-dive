package _01_Fundamentals.BJ2798_블랙잭;

// N개의 수가 주어지면 카드 3장을 골라서 M과 같거나 가장 가까운수를 리턴
// 3 <= N <= 100  10 <= M <= 300000
// 3장 뽑으니까
// 3*2*1 분의 100 * 99 * 98, N은 161,700
// 주어진 시간은 1초, 약 100,000,000번 계산 까지 허용
// O(N4)까지 가능

// 최적화 하기위해 투포인터 사용해보기.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 투 포인터를 위한 정렬 (O(N log N))
        Arrays.sort(numbers);

        int result = 0; // 최종 결과값 저장

        // 2. 한 숫자를 고정하고 나머지 두 숫자를 투 포인터로 탐색 (O(N^2))
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];

                if (sum == M) { // 정확히 M이면 최상의 결과이므로 즉시 종료
                    System.out.println(sum);
                    return;
                }

                if (sum < M) {
                    // M보다 작다면, 기존 결과보다 M에 더 가까운지 확인 후 갱신
                    if (sum > result) {
                        result = sum;
                    }
                    left++; // 더 큰 합을 위해 왼쪽 포인터 이동
                } else {
                    // M보다 크다면 블랙잭 규칙 위반이므로 합을 줄이기 위해 오른쪽 포인터 이동
                    right--;
                }
            }
        }
        System.out.println(result);
    }
}
