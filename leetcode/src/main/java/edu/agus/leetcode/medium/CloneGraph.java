package edu.agus.leetcode.medium;

import java.util.*;

public class CloneGraph {
  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  public Node dfs(Map<Node, Node> visited, Node node) {
    if (visited.containsKey(node)) return visited.get(node);
    else {
      Node res = new Node(node.val);
      List<Node> neighbors = new ArrayList<>();
      for (Node n : node.neighbors) {
        neighbors.add(dfs(visited, n));
      }
      res.neighbors = neighbors;
      visited.put(node, res);
      return res;
    }
  }

  public Node cloneGraph(Node node) {
    Map<Node, Node> visited = new HashMap<>();
    return dfs(visited, node);
  }
}
