package _10_Trie_KMP.Template;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // 자식 노드들을 저장 (Key: 문자, Value: 해당 문자의 노드)
    Map<Character, TrieNode> childNodes = new HashMap<>();
    // 해당 노드가 단어의 끝인지 여부
    boolean isEndOfWord;
}

public class Trie {
    private final TrieNode root;

    public Trie(TrieNode root) {
        this.root = root;
    }

    // 1. 단어 삽입
    public void insert(String word) {
        TrieNode node = this.root;

        for(int i = 0; i < word.length(); i++) {
            // 문자가 없으면 새로 생성, 있으면 가져옴
            node = node.childNodes.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        // 마지막 글자 노드에 단어의 끝임을 표시
        node.isEndOfWord = true;
    }

    // 2. 단어 검색(Search)
    public boolean search(String word) {
        TrieNode node = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.childNodes.get(ch);
        }
        // 경로가 있어도 단어의 끝 표시가 있어야 완전한 단어
        return node.isEndOfWord;
    }

    // 3. 접두사 검색(StartWith)
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            node = node.childNodes.get(ch);

            if(node == null) return false;
        }
        return true; // 끝과 상관없이 경ㅇㄹ오만 존재하면 접두사 인정
    }
    
    public static void main(String[] args) {


    }
}
