package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    if (head == null) return null;
    Node copy = head.next;
    Node hclone = new Node(head.val);
    Node clone = hclone;
    Map<Node, Node> dict = new HashMap<>();
    dict.put(head, hclone);
    while (copy != null) {
      clone.next = new Node(copy.val);
      clone = clone.next;
      dict.put(copy, clone);
      copy = copy.next;
    }
    clone = hclone;
    while (head != null && hclone != null) {
      hclone.random = head.random == null ? null : dict.get(head.random);
      head = head.next;
      hclone = hclone.next;
    }
    return clone;
  }
}
