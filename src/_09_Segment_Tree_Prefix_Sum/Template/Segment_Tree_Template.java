package _09_Segment_Tree_Prefix_Sum.Template;

import javax.lang.model.type.PrimitiveType;
import java.io.*;
import java.util.*;

/**
 * 구간을 쪼개서 이진 트리로 관리하는 데이터 구조
 *
 */

public class Segment_Tree_Template {
    static long[] tree;
    static int[] arr;

    public static void main(String[] args) {
        arr = new int[]{0,1,2,3,4,5,6};
        tree = new long[arr.length * 4];

        build(1,1,6);

        System.out.println(query(1,1,4,2,4));


    }

    static void build(int node, int start, int end) {
        // 1. 바닥 찍기
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid); // 2. 왼쪽 끝까지 가기
        build(node * 2 + 1, mid + 1, end); // 3. 오른쪽으로 가기
        tree[node] = tree[node * 2] + tree[node * 2 + 1]; // 4. 다 돌아오면 밑에 자식들의 합을 나로 계산
    }

    static long query(int node, int start, int end, int left, int right) {
        // 1. 범위를 벗어난 경우 : 더할 필요 없음
        if(left >= end || right < start) {
            return 0;
        }

        // 2. 현재 노드의 범위가 목표에 포함되는 경우 : 더 내려갈 필요 없이 이 노드의 값을 바로 반환
        if(left <= start && end <= right) {
            return tree[node];
        }

        // 3. 걸쳐 있는 경우 : 자식들에게 물러보러 내려감
        // 왼쪽과 오른쪽중 하나만 포함될경우 하나는 0을 반환하고 (1번 종료 로직)
        // 다른 하나는 본인을 반환하거나 자식에게 물어보러감 (2번 or 재귀)
        int mid = (start + end) / 2;
        long lsum = query(node * 2, start, mid, left, right);
        long rsum = query(node * 2 + 1, mid + 1, end, left, right);

        return lsum + rsum;
    }

    static void update(int node, int start, int end, int index, int newValue) {
        // 1. 범위를 완전히 벗어난 경우 복귀
        if(index < start || index > end) {
            return;
        }

        // 2. 리프 노드에 도착한 경우 값 변경
        if(start == end) {
            tree[node] = newValue;
            return;
        }
        int mid = (start + end) / 2;

        // 3. 현재 노드 범위 안에 index가 포함될 경우 자식들을 더 확인
        update(node * 2, start, mid, index, newValue);
        update(node * 2 + 1, mid + 1, end, index, newValue);

        // 4. 자식들이 바뀌었으나 나 자신도 업데이트
        tree[node] = tree[node * 2] + tree[node * 2 + 1];


    }
}
