package edu.agus.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class LFUCache {
  int lowFreq, capacity;
  Map<Integer, Integer> cache;
  Map<Integer, Integer> keyToFreq;
  Map<Integer, Set<Integer>> freqMap;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();
    keyToFreq = new HashMap<>();
    freqMap = new HashMap<>();
  }

  public int get(int key) {
    if(capacity == 0 || !cache.containsKey(key)) return -1;

    int oldFreq = keyToFreq.get(key);
    keyToFreq.put(key, oldFreq+1);
    freqMap.get(oldFreq).remove(key);

    if(oldFreq == lowFreq && freqMap.get(lowFreq).isEmpty()) lowFreq++;

    freqMap.computeIfAbsent(oldFreq + 1, k -> new LinkedHashSet<>())
        .add(key);

    return cache.get(key);
  }

  public void put(int key, int value) {
    if(capacity == 0) return;

    if(cache.containsKey(key)) {
      cache.put(key, value);
      get(key);
      return;
    }

    if(cache.size() >= capacity) {
      int evict = freqMap.get(lowFreq).iterator().next();
      freqMap.get(lowFreq).remove(evict);
      keyToFreq.remove(evict);
      cache.remove(evict);
    }

    cache.put(key, value);
    keyToFreq.put(key, 1);

    lowFreq = 1;

    freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>())
        .add(key);
  }
}
