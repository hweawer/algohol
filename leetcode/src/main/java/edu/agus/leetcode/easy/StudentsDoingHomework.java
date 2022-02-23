package edu.agus.leetcode.easy;

public class StudentsDoingHomework {
  public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    int n = startTime.length;
    int total = 0;
    for (int i = 0; i < n; i++) {
      if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
        total++;
      }
    }
    return total;
  }
}
