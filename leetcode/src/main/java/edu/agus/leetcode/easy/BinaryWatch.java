package edu.agus.leetcode.easy;

import java.util.*;

public class BinaryWatch {
  public List<String> readBinaryWatch(int turnedOn) {
    List<String> allPossibleTimes = new ArrayList<>();

    for (int hour = 0; hour < 12; hour++) {
      for (int minute = 0; minute < 60; minute++) {
        if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
          StringBuilder time = new StringBuilder();
          time.append(hour).append(":");
          if (minute < 10) {
            time.append("0");
          }
          time.append(minute);
          allPossibleTimes.add(time.toString());
        }
      }
    }
    return allPossibleTimes;
  }
}
