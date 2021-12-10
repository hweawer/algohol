package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LargestNumber {
  private static Comparator<Integer> cmp = (x1, x2) -> {
    if (x1 == 0 && x2 == 0) return 0;
    else if (x1 == 0) return -1;
    else if (x2 == 0) return 1;
    else {
      int digits1 = (int) Math.log10(x1);
      int digits2 = (int) Math.log10(x2);

      int pow1 = (int) Math.pow(10, digits1 + 1);
      int pow2 = (int) Math.pow(10, digits2 + 1);

      long firstComposition = (long) x2 * pow1 + x1;
      long secondComposition = (long) x1 * pow2 + x2;

      return Long.compare(secondComposition, firstComposition);
    }
  };


  public String largestNumber(int[] nums) {
    List<Integer> al = Arrays.stream(nums).boxed().sorted(cmp.reversed()).collect(Collectors.toList());
    StringBuilder sb = new StringBuilder();
    al.forEach(x -> {
      if (sb.length() != 0 && sb.charAt(0) == '0' && x == 0) {
      } else sb.append(x);
    });
    return sb.toString();
  }
}
