package edu.agus.leetcode.design;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {
  public interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
  }

  Queue<Integer> q;

  private void initialize(List<NestedInteger> nestedList) {
    for (NestedInteger ni : nestedList) {
      if (ni.isInteger()) {
        q.add(ni.getInteger());
      } else {
        initialize(ni.getList());
      }
    }
  }

  public NestedIterator(List<NestedInteger> nestedList) {
    q = new ArrayDeque<>();
    initialize(nestedList);
  }

  @Override
  public Integer next() {
    return q.poll();
  }

  @Override
  public boolean hasNext() {
    return !q.isEmpty();
  }
}
