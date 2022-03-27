package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class SnapshotArray {
  int snap = 0;
  Map<Integer, Integer>[] snapshots;
  Queue<int[]> current = new LinkedList();


  public SnapshotArray(int length) {
    snapshots = new HashMap[length];
    for (int i = 0; i < length; i++) {
      snapshots[i] = new HashMap();
    }
  }

  public void set(int index, int val) {
    current.add(new int[]{index, val});
  }

  public int snap() {
    while (!current.isEmpty()) {
      int[] entry = current.poll();
      int index = entry[0];
      int value = entry[1];
      snapshots[index].put(snap, value);
    }
    return snap++;
  }

  public int get(int index, int snap_id) {
    Map<Integer, Integer> dict = snapshots[index];
    for (int i = snap_id; i >= 0; i--) {
      if (dict.get(i) != null) {
        return dict.get(i);
      }
    }
    return 0;
  }
}
