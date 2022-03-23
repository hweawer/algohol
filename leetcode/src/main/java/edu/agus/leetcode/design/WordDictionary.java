package edu.agus.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
  static class TrieNode {
    Map<Character, TrieNode> edges = new HashMap<>();
    boolean isWordEnd = false;
  }

  TrieNode root = new TrieNode();

  void insert(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      if (!current.edges.containsKey(c)) {
        current.edges.put(c, new TrieNode());
      }
      current = current.edges.get(c);
    }
    current.isWordEnd = true;
  }

  boolean search(TrieNode subtree, String word) {
    TrieNode current = subtree;
    for (char c : word.toCharArray()) {
      if (!current.edges.containsKey(c)) return false;
      current = current.edges.get(c);
    }
    return current.isWordEnd;
  }

  public WordDictionary() {

  }

  public void addWord(String word) {
    insert(word);
  }

  boolean dfs(String word, int ind, TrieNode node) {
    if (ind >= word.length()) return node.isWordEnd;
    if (node.edges.isEmpty()) return false;
    char c = word.charAt(ind);
    boolean res = false;
    if (c == '.') {
      for (Map.Entry<Character, TrieNode> en : node.edges.entrySet()) {
        res = res || dfs(word, ind + 1, en.getValue());
      }
    } else if (node.edges.containsKey(c)) res = dfs(word, ind + 1, node.edges.get(c));

    return res;
  }

  public boolean search(String word) {
    return dfs(word, 0, root);
  }
}
