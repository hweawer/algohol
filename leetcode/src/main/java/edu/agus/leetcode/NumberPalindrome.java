package edu.agus.leetcode;

public class NumberPalindrome {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int y = x;
    int div = 1;
    while (y >= 10) {
      y /= 10;
      div *= 10;
    }
    int mod = 10;
    while (div >= mod) {
      int div_r = x / div;
      int mod_r = x % mod;
      if (div_r != mod_r) return false;
      x %= div;
      x /= 10;
      div /= 100;
    }
    return true;
  }

  public boolean IsPalindromeSolution(int x) {
    // Special cases:
    // As discussed above, when x < 0, x is not a palindrome.
    // Also if the last digit of the number is 0, in order to be a palindrome,
    // the first digit of the number also needs to be 0.
    // Only 0 satisfy this property.
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }

    // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
    // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
    // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
    return x == revertedNumber || x == revertedNumber / 10;
  }
}
