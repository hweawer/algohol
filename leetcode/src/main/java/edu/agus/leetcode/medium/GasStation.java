package edu.agus.leetcode.medium;

public class GasStation {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int deficit = 0;
    int start = 0;
    int balance = 0;
    for (int i = 0; i < gas.length; i++) {
      balance += gas[i] - cost[i];

      if (balance < 0) {
        deficit -= balance;
        balance = 0;
        start = i + 1;
      }
    }

    if (balance >= deficit) return start;
    return -1;
  }
}
