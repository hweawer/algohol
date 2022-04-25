package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
  Iterator<Integer> it;
  List<Integer> list = new ArrayList();
  boolean wasPeek = false;

  public PeekingIterator(Iterator<Integer> iterator) {
    this.it = iterator;
  }

  public Integer peek() {
    if (!wasPeek) {
      list.add(it.next());
      wasPeek = true;
    }
    return list.get(list.size() - 1);
  }

  @Override
  public Integer next() {
    if (!wasPeek) {
      list.add(it.next());
    } else {
      wasPeek = false;
    }
    return list.get(list.size() - 1);
  }

  @Override
  public boolean hasNext() {
    if (!it.hasNext() && wasPeek) return true;
    return it.hasNext();
  }
}
