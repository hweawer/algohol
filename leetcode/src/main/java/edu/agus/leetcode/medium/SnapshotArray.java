package edu.agus.leetcode.medium;

import java.util.*;

class SnapshotArray {
  int snapshot = 0;
  TreeMap<Integer, Integer>[] arr;

  public SnapshotArray(int length) {
    arr = new TreeMap[length];
    for (int i = 0; i< length; i++) {
      arr[i] = new TreeMap();
    }
  }

  public void set(int index, int val) {
    TreeMap<Integer, Integer> dict = arr[index];
    dict.put(snapshot, val);
  }

  public int snap() {
    return snapshot++;
  }

  public int get(int index, int snap_id) {
    Map.Entry<Integer, Integer> en = arr[index].floorEntry(snap_id);
    if (en == null) return 0;
    return en.getValue();
  }
}
