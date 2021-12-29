package edu.agus.leetcode.easy;

public class PartitionArrayIntoThreePartsWithEqualSum {
  public boolean canThreePartsEqualSum(int[] arr) {
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    if (sum % 3 != 0) return false;
    int sumPart = sum / 3;
    int count = 0;
    int acc = 0;

    for (int j : arr) {
      acc += j;
      if (acc == sumPart) {
        count++;
        acc = 0;
      }
    }
    return count >= 3;
  }
}
