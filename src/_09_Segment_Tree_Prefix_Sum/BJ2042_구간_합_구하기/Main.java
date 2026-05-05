package _09_Segment_Tree_Prefix_Sum.BJ2042_구간_합_구하기;

// 첫째줄 수의 개수 N, 변경이 일어나는 횟수 M, 구간 합 구하는 횟수 K
// a가 1인 경우 - b번 째 수를 c로 바꿈 Update
// a가 2인 경우 - b번 째 수부터 c번째 수까지 합 구하기 Query

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. N M K 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 초기화
        arr = new long[N+1];
        tree =  new long[N * 4];

        // 2. N 만큼 입력 받기
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 3. build
        build(1,1, N);

        // 4. 1이면 쿼리 후 출력, 2면 update
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1) {
                update(1, 1, N, b, Long.parseLong(st.nextToken()));
            }

            if(a == 2) {
                sb.append(query(1, 1, N, b, Integer.parseInt(st.nextToken()))).append("\n");
            }

        }

        System.out.println(sb);

    }

    static void update(int node, int start, int end, int index, long newValue) {
        // 1. 범위를 벗어나면 복귀
        if(index < start || index > end) {
            return;
        }

        // 2. 업데이트 할 인덱스면 업데이트
        if( start == end) {
            tree[node] = newValue;
            return;
        }

        int mid = (start + end) / 2;

        update(node * 2, start, mid, index, newValue);
        update(node * 2 + 1, mid + 1, end, index, newValue);

        // 자식이 업데이트 되었으면 나도 업데이트
        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }


    static long query(int node, int start, int end, int left, int right) {
        if( left > end || right < start) return 0;
        if( left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        long lsum = query(node * 2, start, mid, left, right);
        long rsum = query(node * 2 + 1, mid + 1, end, left, right);

        return lsum + rsum;

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
}
