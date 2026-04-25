package _02_Searching_Sorting.BJ11286_절댓값_힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.PriorityQueue;

/**
 * 절댓값 힙
 * 1. 배열에 x(x != 0)를 넣는다
 * 2. 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
 *  - 절대값이 가장 작은 값이 여러개일 때 = 가장 작은 수를 출력 후 그 값을 배열에서 제거
 *
 *  입력
 *  첫째 줄 연산의 수 N (1 <= N <= 100000)
 *  다음 줄 N개 줄에 대한 연산의 정보를 나타내는 정수 x
 *   - x가 0이 아니면 배열에 x값 추가
 *   - 0이면 절댓값이 가장 작은 값을 출력하고 제거
 *
 * */

public class Main {
    static int n, x;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        pq = new PriorityQueue<>((o1, o2) -> {
           int abs1 = Math.abs(o1);
           int abs2 = Math.abs(o2);
           if(abs1 == abs2) return Integer.compare(o1, o2);
           return Integer.compare(abs1, abs2);
        });

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());

            if(x != 0) {
                pq.add(x);
            }else {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll());
                    sb.append("\n");
                }else {
                    sb.append("0");
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
