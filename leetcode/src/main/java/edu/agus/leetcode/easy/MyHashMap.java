package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {
  public class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final List<List<Entry>> map;
  private static final int INITIAL_CAPACITY = 16;
  private int size;

  public MyHashMap() {
    map = new ArrayList<>(INITIAL_CAPACITY);
    for (int i = 0; i < INITIAL_CAPACITY; i++) {
      map.add(0, new ArrayList<>());
    }
    size = INITIAL_CAPACITY;
  }

  public void put(int key, int value) {
    int index = key % size;
    List<Entry> box = map.get(index);
    for (Entry e : box) {
      if (e.key == key) {
        e.value = value;
        return;
      }
    }
    box.add(new Entry(key, value));
  }

  public int get(int key) {
    int index = key % size;
    List<Entry> box = map.get(index);
    for (Entry e : box) {
      if (e.key == key) return e.value;
    }
    return -1;
  }

  public void remove(int key) {
    int index = key % size;
    map.get(index).removeIf(e -> e.key == key);
  }
}
