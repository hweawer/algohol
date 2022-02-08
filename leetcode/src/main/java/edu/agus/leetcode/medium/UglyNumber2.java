package edu.agus.leetcode.medium;

public class UglyNumber2 {
  public int nthUglyNumber(int n) {
    int[] mem = new int[n];
    mem[0] = 1;
    int tw = 0, th = 0, fv = 0;
    for (int i = 1; i < n; i++) {
      int ptw = mem[tw] * 2, pth = mem[th] * 3, pfv = mem[fv] * 5;
      mem[i] = Math.min(ptw, Math.min(pth, pfv));
      if (ptw == mem[i]) tw++;
      if (pth == mem[i]) th++;
      if (pfv == mem[i]) fv++;
    }
    return mem[n-1];
  }
}
