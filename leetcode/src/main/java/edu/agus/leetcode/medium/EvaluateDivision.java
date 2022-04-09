package edu.agus.leetcode.medium;

import java.util.*;

public class EvaluateDivision {
  class Edge {
    double cost;
    String v;

    Edge(double c, String v) {
      this.cost = c;
      this.v = v;
    }
  }

  class BFSNode {
    double acc;
    String v;

    BFSNode(double acc, String v) {
      this.acc = acc;
      this.v = v;
    }
  }

  double bfs(String in, String out, Map<String, List<Edge>> adj) {
    if (!adj.containsKey(in) || !adj.containsKey(out)) return -1.0;
    Set<String> visited = new HashSet();
    Queue<BFSNode> q = new LinkedList();
    for (Edge e : adj.get(in)) {
      q.add(new BFSNode(e.cost, e.v));
      visited.add(e.v);
    }
    while (!q.isEmpty()) {
      BFSNode node = q.poll();
      if (node.v.equals(out)) return node.acc;

      for (Edge e : adj.get(node.v)) {
        if (!visited.contains(e.v)) {
          q.add(new BFSNode(e.cost * node.acc, e.v));
          visited.add(e.v);
        }
      }
    }
    return -1.0;
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Edge>> adj = new HashMap();

    for (int i = 0; i < equations.size(); i++) {
      List<String> verticies = equations.get(i);
      double cost = values[i];

      Edge in = new Edge(cost, verticies.get(1));
      Edge out = new Edge(1 / cost, verticies.get(0));

      List<Edge> inAdj = adj.getOrDefault(verticies.get(0), new ArrayList());
      inAdj.add(in);
      adj.put(verticies.get(0), inAdj);
      List<Edge> outAdj = adj.getOrDefault(verticies.get(1), new ArrayList());
      outAdj.add(out);
      adj.put(verticies.get(1), outAdj);
    }

    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      res[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), adj);
    }
    return res;
  }
}
