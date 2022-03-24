package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
  List<String> ans = new ArrayList<>();

  void backtracking(String current, List<String> acc) {
    if (current.isEmpty()) return;
    if (acc.size() == 3 && validate(current)) {
      ans.add(acc.get(0) + '.' + acc.get(1) + '.' + acc.get(2) + '.' + current);
    }
    for (int i = 1; i < Math.min(current.length(), 4); i++) {
      String prefix = current.substring(0, i);
      if (validate(prefix) && acc.size() < 4) {
        acc.add(prefix);
        String suffix = current.substring(i);
        backtracking(suffix, acc);
        acc.remove(acc.size() - 1);
      }
    }
  }

  public List<String> restoreIpAddresses(String s) {
    if (s.length() < 4) return ans;
    backtracking(s, new ArrayList<>());
    return ans;
  }

  boolean validate(String num) {
    if (num.length() > 3 || (num.length() > 1 && num.charAt(0) == '0')) return false;
    int x = Integer.parseInt(num);
    return x >= 0 && x <= 255;
  }

  public static void main(String[] args) {
    RestoreIpAddresses r = new RestoreIpAddresses();
    r.restoreIpAddresses("0000");
  }
}
