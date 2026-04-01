package _02_Searching_Sorting.BJ2805_나무_자르기;

// 나무가 M 미터 필요하다.
// 절단기 높이 H를 지정해야 함.
// H 보다 큰 나무는 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않음

// 나무가 일렬로
// 20 15 10 17이 있다고 가정
// 나무가 7미터 필요함.
// 그래서 높이를 15로 지정하고 자르면
// 15(-5) 15 10 15(-2) 5미터와 2미터를 가져가면서 7미터를 가져감

// 입력 나무의 수 N ( 1<= N <= 1,000,000) 필요한 나무의 길이M ( 1<= M <= 2,000,000,000)
// 출력 M미터 나무를 집에 가기위한 절단기에 설정할 수 있는 높이H 최댓값 출력.

// 나무 를 자르면서 한번씩 모두 비교
// 나무의 수 N 100만 가져가려는 나무길이 20억


// 브루트 포스 20억 x 100만 = 2000조 X
// 이분 탐색 31번 X 나무확인 100만 3100만. O

// 정렬은 필요없음. 모두 순회하면 31번이 동일


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무 개수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[N];
        long high = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > high) high = trees[i]; // 제일 높은 나무 찾기
        }

        long low = 0;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2; // 이번에 시도할 절단기 높이
            long sum = 0;

            // 나무 자르기 시뮬레이션
            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            if (sum >= M) {
                // 나무가 충분함 -> 절단기 높이를 더 높여보자 (최댓값 찾기)
                result = mid;
                low = mid + 1;
            } else {
                // 나무가 부족함 -> 절단기 높이를 낮춰야 함
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}