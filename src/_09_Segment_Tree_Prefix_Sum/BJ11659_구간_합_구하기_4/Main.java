package _09_Segment_Tree_Prefix_Sum.BJ11659_구간_합_구하기_4;

// 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        tree = new long[n * 4];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        build(1,1, n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(query(1,1, n, a, b));
            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void build(int node, int start, int end) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int start, int end, int left, int right) {
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        long lsum = query(node * 2, start, mid, left, right);
        long rsum = query(node * 2 + 1, mid + 1, end, left, right);

        return lsum + rsum;
    }
}
