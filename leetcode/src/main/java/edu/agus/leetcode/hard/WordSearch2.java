package edu.agus.leetcode.hard;

import java.util.*;

public class WordSearch2 {
  static class TrieNode {
    Map<Character, TrieNode> edges = new HashMap<>();
    boolean isWordEnd = false;
  }

  TrieNode root = new TrieNode();
  boolean[][] visited;
  Set<String> res = new HashSet<>();

  public void insert(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      if (!current.edges.containsKey(c)) {
        current.edges.put(c, new TrieNode());
      }
      current = current.edges.get(c);
    }
    current.isWordEnd = true;
  }

  public TrieNode find(TrieNode node, String word) {
    TrieNode current = node;
    for (char c : word.toCharArray()) {
      if (!current.edges.containsKey(c)) return null;
      current = current.edges.get(c);
    }
    return current;
  }

  public void dfs(char[][] board, int i, int j, int m, int n, StringBuilder sb, TrieNode root) {
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
    sb.append(board[i][j]);
    TrieNode prefix = find(root, String.valueOf(board[i][j]));
    if (prefix == null) {
      sb.deleteCharAt(sb.length() - 1);
      return;
    }
    if (prefix.isWordEnd) {
      String acc = sb.toString();
      res.add(acc);
    }
    visited[i][j] = true;
    dfs(board, i - 1, j, m, n, sb, prefix);
    dfs(board, i, j + 1, m, n, sb, prefix);
    dfs(board, i + 1, j, m, n, sb, prefix);
    dfs(board, i, j - 1, m, n, sb, prefix);
    visited[i][j] = false;
    sb.deleteCharAt(sb.length() - 1);
  }

  public List<String> findWords(char[][] board, String[] words) {
    int m = board.length;
    int n = board[0].length;
    visited = new boolean[m][n];
    for (String word : words) insert(word);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, i, j, m, n, new StringBuilder(), root);
      }
    }
    return new ArrayList<>(res);
  }

  public static void main(String[] args) {
    WordSearch2 ws = new WordSearch2();
    System.out.println(ws.findWords(new char[][]{
        {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
    }, new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}));

  }
}
