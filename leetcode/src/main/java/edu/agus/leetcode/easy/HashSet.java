package edu.agus.leetcode.easy;

public class HashSet {
  class MyHashSet {
    boolean[] arr = new boolean[1000001];

    public MyHashSet() {

    }

    public void add(int key) {
      arr[key] = true;
    }

    public void remove(int key) {
      arr[key] = false;
    }

    public boolean contains(int key) {
      return arr[key];
    }
  }
}
