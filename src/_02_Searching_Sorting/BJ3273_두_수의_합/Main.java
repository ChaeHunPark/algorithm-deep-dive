package _02_Searching_Sorting.BJ3273_두_수의_합;

// 제한 시간 1초 (100,000,000
// 1<= n <= 100000

// 2중 포문 O(N2) X

// 정렬 후 투포인터 O(N log N) + O(N) 으로 풀이 약 1,700,000


// 입력
// 9 -> n의 갯수
// 5 12 7 10 9 1 2 3 11 -> n들이 담긴 아이들
// 13 -> 두수의 합이 13이 되는경우 찾기

// 출력
// 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int result = 0; // 정답
    static int n; // n의 갯수 입력 받기
    static int target; // 두 수의 합의 목표
    static int[] array; // 입력 받을 배열


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // n 입력 받기
        array = new int[n]; // n에 맞는 array 생성

        StringTokenizer st = new StringTokenizer(br.readLine());

        // n을 입력 받아서 배열에 저장
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(br.readLine());

        // 정렬
        Arrays.sort(array);

            int left = 0;
            int right = n-1;
            int sum = 0;

            while (left < right) {
                sum = array[left] + array[right];

                // 두 수의 합이 target이랑 같으면?
                if(sum== target) {
                    result++; // 정답의 수 늘리기
                    left++;
                    right--;
                }

                if(target < sum) right--;
                if(target > sum) left++;
            }


        System.out.println(result);

    }
}
