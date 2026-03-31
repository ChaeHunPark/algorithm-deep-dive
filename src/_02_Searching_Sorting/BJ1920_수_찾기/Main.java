package _02_Searching_Sorting.BJ1920_수_찾기;

// 첫번 째 입력 자연수의 갯수 N이 주어진다.
// 두번 째 입력 N개의 자연수가 주어진다.
// 세번 째 입력 자연수의 갯수 M이 주어진다.
// 네번 째 입력 M개의 자연수가 주어진다.

// M 배열을 순회하면서 N에 포함되는가 확인하기.

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nArray = new int[n]; // n의 자연수들이 담길 배열
        StringTokenizer nst = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nArray[i] = Integer.parseInt(nst.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer mst = new StringTokenizer(br.readLine());

        Arrays.sort(nArray);
        for (int i = 0; i < m; i++) {
            if(Arrays.binarySearch(nArray, Integer.parseInt(mst.nextToken())) >= 0) {
                sb.append("1").append("\n");
            }else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);


    }
}
