package edu.agus.leetcode.medium;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies {
  public boolean ableToCreate(String rec, Map<String, Set<String>> adj, Set<String> having, Set<String> visited) {
    if (having.contains(rec)) return true;
    if (!adj.containsKey(rec) || visited.contains(rec)) return false;
    visited.add(rec);
    Set<String> ingr = adj.get(rec);
    boolean res = true;
    for (String i : ingr) {
      if (!having.contains(i)) {
        res = ableToCreate(i, adj, having, visited);
        if (res) {
          having.add(i);
        } else return false;
      }
    }
    return res;
  }

  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Map<String, Set<String>> adj = new HashMap();
    for (int i = 0; i < recipes.length; i++) {
      adj.put(recipes[i], new HashSet(ingredients.get(i)));
    }

    Set<String> having = new HashSet();
    for (String s : supplies) {
      having.add(s);
    }
    List<String> res = new ArrayList();
    Set<String> visited = new HashSet();
    for (String rec : recipes) {
      if (ableToCreate(rec, adj, having, visited)) {
        res.add(rec);
        having.add(rec);
      }
    }
    return res;
  }
}
