package edu.agus.leetcode.easy;

public class RobotReturnToOrigin {
  public boolean judgeCircle(String moves) {
    int left = 0;
    int right = 0;
    int up = 0;
    int down = 0;
    for (int i = 0; i < moves.length(); i++) {
      if (moves.charAt(i) == 'U') {
        up++;
      } else if (moves.charAt(i) == 'D') {
        down++;
      } else if (moves.charAt(i) == 'L') {
        left++;
      } else if (moves.charAt(i) == 'R') {
        right++;
      }
    }
    int res = Math.abs(left - right) + Math.abs(up - down);
    return res == 0;
  }
}
