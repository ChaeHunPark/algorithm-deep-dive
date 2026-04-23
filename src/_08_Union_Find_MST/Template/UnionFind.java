package _08_Union_Find_MST.Template;

public class UnionFind {
    static int[] parent;

    public static void main(String[] args) {
        int n = 5; // 노드의 개수
        parent = new int[n + 1];

        // 1. 초기화 : 처음엔 자기 자신이 자기의 루트
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        // index 0 1 2 3 4 5
        //       x 1 2 3 4 5


        // 연산 테스트
        union(1, 2);
        union(2, 3);

        // index 0 1 2 3 4 5
        //       X 2 3 3 4 5

    }

    // find 연산 루트를 찾는 과정 + 경로 압축(Path Compression)
    public static int find(int x) {
        if (parent[x] == x) return x;
        // 재귀를 돌며 루트를 찾음과 동시에, 내 부모를 루트로 직접 연결(속도 최적화)
        return parent[x] = find(parent[x]);
    }


    // Union 연산 두팀을 합치는 과정
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
