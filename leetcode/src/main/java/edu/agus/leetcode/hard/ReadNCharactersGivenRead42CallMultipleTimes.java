package edu.agus.leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharactersGivenRead42CallMultipleTimes {
  Queue<Character> q = new LinkedList();

  int read4(char[] buf4) {
    return 0;
  }

  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return The number of actual characters read
   */
  public int read(char[] buf, int n) {
    int index = 0;
    while (!q.isEmpty() && index < n) {
      buf[index++] = q.poll();
    }
    char[] buf4 = new char[4];
    while (index < n) {
      int curread = read4(buf4);
      if (curread == 0) break;
      for (int i = 0; i < curread; i++) {
        if (index < n) {
          buf[index++] = buf4[i];
        } else {
          q.add(buf4[i]);
        }
      }
    }
    return index;
  }
}
