package edu.agus.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
  public int oddEvenJumps(int[] arr) {
    int jumpsPossible = 1;

    int len = arr.length;

    boolean[] isOddJumpPossible = new boolean[len];
    boolean[] isEvenJumpPossible = new boolean[len];

    TreeMap<Integer, Integer> map = new TreeMap<>();

    // last element is always possible jump
    isOddJumpPossible[len - 1] = true;
    isEvenJumpPossible[len - 1] = true;
    map.put(arr[len - 1], len - 1);


    for (int i = len - 2; i >= 0; i--) {
      Map.Entry<Integer, Integer> elementIfOddJump = map.ceilingEntry(arr[i]);
      Map.Entry<Integer, Integer> elementIfEvenJump = map.floorEntry(arr[i]);
      if (elementIfOddJump != null) {
        isOddJumpPossible[i] = isEvenJumpPossible[elementIfOddJump.getValue()];
      }
      if (elementIfEvenJump != null) {
        isEvenJumpPossible[i] = isOddJumpPossible[elementIfEvenJump.getValue()];
      }

      if (isOddJumpPossible[i]) {
        jumpsPossible++;
      }

      map.put(arr[i], i);
    }

    return jumpsPossible;
  }
}
