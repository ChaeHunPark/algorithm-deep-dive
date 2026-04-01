package _00_Theory_Concepts.Time_Complexity;

import java.util.Arrays;
import java.util.HashMap;

public class TimeComplexityExamples {

    // 1. O(1) : 상수 시간 (Constant Time)
    // 데이터 양(N)에 상관없이 한 번 실행
    public void constantTime(int[] arr, HashMap hashMap) {
        System.out.println(arr[0]); // 배열 인덱스 접근
        hashMap.get(0);  // 해시맵 탐색 등
    }

    // 2. O(N) : 선형 시간(Linear Time)
    // N의 크기 만큼 정직하게 반복 (N=10,000,000까지 1초 내 세이프)
    public void linearTime(int N){
        for (int i = 0; i < N; i++) {
            //단순 탐색, 최댓값 찾기, 투포인터 등
        }
    }

    // 3. O(N log N) : 로그 선형 시간
    // 정렬 알고리즘의 표준 (N=100,000~1,000,000일 때 주로 사용)
    public void nLogNTime(int[] arr) {
        Arrays.sort(arr);
    }

    // 4.O(N^2) : 이차 시간(Quadratic Time)
    // 이중 for문 (N=2,000까지 안전, 그 이상은 위험)
    public void quadraticTime(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 버블 정렬, 삽입 정렬, 2차원 배열 순회 등
            }
        }
    }

    // 5. O(^3) : 삼차시간 (Cubic Time)
    // 삼중 for문 (N=500까지만 가능)
    public void cubicTime(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // 3개의 조합 찾기 등
                }
            }
        }
    }


}
