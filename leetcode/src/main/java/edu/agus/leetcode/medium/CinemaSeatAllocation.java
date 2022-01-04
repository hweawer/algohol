package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

//todo: it is not a bitmask solution
public class CinemaSeatAllocation {

  public static class Seat {
    boolean left = true;
    boolean right = true;
    boolean center = true;
  }

  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    Map<Integer, Seat> set = new HashMap<>();
    for (int[] reservedSeat : reservedSeats) {
      if (!set.containsKey(reservedSeat[0])) {
        set.put(reservedSeat[0], new Seat());
      }
      int place = reservedSeat[1];
      if (place == 2 || place == 3) {
        set.get(reservedSeat[0]).left = false;
      }
      if (place == 4 || place == 5) {
        set.get(reservedSeat[0]).left = false;
        set.get(reservedSeat[0]).center = false;
        set.get(reservedSeat[0]).right = false;
      }
      if (place == 7 || place == 8) {
        set.get(reservedSeat[0]).right = false;
      }
    }
    int res = 0;
    for (Map.Entry<Integer, Seat> en : set.entrySet()) {
      if (en.getValue().left && en.getValue().right) res += 2;
      else if (en.getValue().left || en.getValue().center || en.getValue().right) res++;
    }
    return res + (n - set.size()) * 2;
  }
}
