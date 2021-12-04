package edu.agus.leetcode.medium;

class Trie {
  private final static int k = 26;
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode v = root;
    for (int i = 0; i < word.length(); i++) {
      int ind = word.charAt(i) - 'a';
      if (v.childs[ind] == null) {
        v.childs[ind] = new TrieNode();
      }
      v = v.childs[ind];
    }
    v.terminal = true;
  }

  public boolean search(String word) {
    TrieNode v = root;
    for (int i = 0; i < word.length(); i++) {
      int ind = word.charAt(i) - 'a';
      if (v.childs[ind] == null) return false;
      v = v.childs[ind];
    }
    return v.terminal;
  }

  public boolean startsWith(String prefix) {
    TrieNode v = root;
    for (int i = 0; i < prefix.length(); i++) {
      int ind = prefix.charAt(i) - 'a';
      if (v.childs[ind] == null) return false;
      v = v.childs[ind];
    }
    return true;
  }

  public static class TrieNode {
    TrieNode[] childs = new TrieNode[k];
    boolean terminal = false;
  }
}
