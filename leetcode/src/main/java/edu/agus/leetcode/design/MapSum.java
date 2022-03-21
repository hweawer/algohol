package edu.agus.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
  static class TrieNode {
    Map<Character, TrieNode> edges = new HashMap<>();
    boolean isWordEnd = false;
    int val = -1;
  }

  TrieNode root;

  public MapSum() {
    root = new TrieNode();
  }

  public void insert(String key, int val) {
    TrieNode current = root;
    for (char c : key.toCharArray()) {
      if (!current.edges.containsKey(c)) {
        current.edges.put(c, new TrieNode());
      }
      current = current.edges.get(c);
    }
    current.isWordEnd = true;
    current.val = val;
  }

  private TrieNode find(String prefix) {
    TrieNode current = root;
    for (char c : prefix.toCharArray()) {
      if (!current.edges.containsKey(c)) return null;
      current = current.edges.get(c);
    }
    return current;
  }

  private int sum(TrieNode node) {
    int res = node.isWordEnd ? node.val : 0;
    for (Map.Entry<Character, TrieNode> en : node.edges.entrySet()) {
      res += sum(en.getValue());
    }
    return res;
  }

  public int sum(String prefix) {
    TrieNode subTrie = find(prefix);
    if (subTrie == null) return 0;
    return sum(subTrie);
  }
}
