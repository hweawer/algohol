package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
  Map<String, TreeMap<Integer, String>> cache = new HashMap();

  public TimeBasedKeyValueStore() {

  }

  public void set(String key, String value, int timestamp) {
    TreeMap<Integer, String> tree = cache.getOrDefault(key, new TreeMap());
    tree.put(timestamp, value);
    cache.put(key, tree);
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> tree = cache.get(key);
    if (tree == null) return "";
    Map.Entry<Integer, String> en = tree.floorEntry(timestamp);
    if (en == null) return "";
    return en.getValue();
  }
}
