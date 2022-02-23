package edu.agus.leetcode.medium;

public class StringCompression {
  public int compress(char[] chars) {
    if (chars.length == 0) return 0;
    char c = chars[0];
    int pos = 0;
    int pointer = 1;
    int count = 1;
    while (pointer < chars.length) {
      if (chars[pointer - 1] == chars[pointer]) count++;
      else {
        chars[pos] = c;
        pos++;
        pos = compressBigNumber(count, chars, pos);
        c = chars[pointer];
        count = 1;
      }
      pointer++;
    }
    chars[pos] = c;
    pos++;
    pos = compressBigNumber(count, chars, pos);
    return pos;
  }

  public int compressBigNumber(int count, char[] chars, int pos) {
    if (count > 1) {
      int n = (int) Math.log10(count);
      for (int i = n; i >= 0; i--) {
        int pow = (int) Math.pow(10, i);
        int c = count / pow;
        count %= pow;
        chars[pos] = (char) (c + '0');
        pos++;
      }
    }
    return pos;
  }
}
