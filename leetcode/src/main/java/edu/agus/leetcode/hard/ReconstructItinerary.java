package edu.agus.leetcode.hard;

import java.util.*;

public class ReconstructItinerary {
  List<String> path = new ArrayList();

  boolean dfs(String current, Map<String, ArrayList<String>> adj) {
    ArrayList<String> edges = adj.get(current);
    if (edges == null || edges.isEmpty()) return adj.values().isEmpty();

    for (int i = 0; i < edges.size(); i++) {
      String e = edges.get(i);
      path.add(e);
      edges.remove(i);
      if (edges.size() == 0) {
        adj.remove(current);
      }
      if (dfs(e, adj)) return true;
      path.remove(path.size() - 1);
      adj.computeIfAbsent(current, k -> new ArrayList());
      adj.get(current).add(i, e);
    }
    return false;
  }

  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, ArrayList<String>> adj = new HashMap();
    for (List<String> ticket : tickets) {
      if (!adj.containsKey(ticket.get(0))) {
        adj.put(ticket.get(0), new ArrayList<>());
      }
      adj.get(ticket.get(0)).add(ticket.get(1));
    }
    for (Map.Entry<String, ArrayList<String>> en : adj.entrySet()) {
      Collections.sort(en.getValue());
    }
    path.add("JFK");
    dfs("JFK", adj);
    return path;
  }
}
