package edu.agus.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] solution = new int[2];

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
        solution[0] = i;
        solution[1] = map.get(target - nums[i]);
        break;
      }
    }
    return solution;
  }
}
