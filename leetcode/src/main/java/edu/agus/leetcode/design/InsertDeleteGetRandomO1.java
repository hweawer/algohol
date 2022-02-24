package edu.agus.leetcode.design;

import java.util.*;

public class InsertDeleteGetRandomO1 {
  static class RandomizedSet {
    private final Map<Integer, Integer> dict;
    private final List<Integer> list;
    private final Random rand;

    public RandomizedSet() {
      dict = new HashMap<>();
      list = new ArrayList<>();
      rand = new Random();
    }

    public boolean insert(int val) {
      if (dict.containsKey(val)) return false;
      int i = list.size();
      list.add(val);
      dict.put(val, i);
      return true;
    }

    public boolean remove(int val) {
      if (!dict.containsKey(val)) return false;
      int i = dict.get(val);
      int last = list.get(list.size() - 1);
      dict.put(last, i);
      dict.remove(val);
      list.set(i, last);
      list.remove(list.size() - 1);
      return true;
    }

    public int getRandom() {
      int size = list.size();
      int i = rand.nextInt(size);
      return list.get(i);
    }
  }

  public static void main(String[] args) {
    RandomizedSet randomizedSet = new RandomizedSet();
    randomizedSet.remove(0);
    randomizedSet.remove(0);
    randomizedSet.insert(0);
    randomizedSet.getRandom();
    randomizedSet.remove(0);
    randomizedSet.insert(0);
  }

}
