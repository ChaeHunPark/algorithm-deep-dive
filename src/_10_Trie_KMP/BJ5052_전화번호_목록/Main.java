package _10_Trie_KMP.BJ5052_전화번호_목록;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> childNode = new HashMap<>();
    boolean isEndOfWord;
}

class Trie {
    private final TrieNode root = new TrieNode();


    public boolean insert(String word) {
        TrieNode node = this.root;

        for (char c : word.toCharArray()) {
            // 1. 삽입하고 있는데 이미 깃발이 있다? false
            if(node.isEndOfWord) return false;
            node = node.childNode.computeIfAbsent(c, k -> new TrieNode()); // 다음 노드로 갈 준비
        }

        // 2. 삽입을 다했는데 이미 다른 자식이 있다? false
        if(!node.childNode.isEmpty()) return false;

        node.isEndOfWord = true;
        return true;
    }

}

public class Main {
    static int t, n; // 테스트 개수, 전화번호 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());


        while (t-- > 0) {

            n = Integer.parseInt(br.readLine());// 전화 번호 갯수
            Trie trie = new Trie(); // 트라이 생성

            String[] phoneNumbers = new String[n];

            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }

            // 짧은 번호순으로 비교하기 위해서 정렬
            Arrays.sort(phoneNumbers);

            boolean isConsistent = true;
            for (String number : phoneNumbers) {
                if(!trie.insert(number)) {
                    isConsistent = false;
                    break;
                }
            }
            sb.append(isConsistent ? "YES\n" : "NO\n");
        }

        System.out.println(sb);

    }
}
