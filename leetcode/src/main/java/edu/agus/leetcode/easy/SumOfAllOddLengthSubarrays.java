package edu.agus.leetcode.easy;

public class SumOfAllOddLengthSubarrays {
  public int sumOddLengthSubarrays(int[] arr) {
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      int total = (arr.length - i) * (i + 1);
      int odd = total % 2 == 0 ? total / 2 : total / 2 + 1;
      res += (arr[i] * odd);
    }
    return res;
  }
}
