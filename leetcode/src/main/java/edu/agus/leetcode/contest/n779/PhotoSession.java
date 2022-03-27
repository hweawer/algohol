package edu.agus.leetcode.contest.n779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhotoSession {
  static long countChanges(String photo) {
    if (photo.length() < 2) return photo.charAt(0) == '1' ? 0 : 1;
    int consec = 0;
    int mid = 0;
    long res = 0;
    for (int left = 0, right = 1; right < photo.length(); left++, right++) {
      if (photo.charAt(left) == photo.charAt(right) && photo.charAt(left) == '0') consec++;
      else if (left > 0) {
        if (photo.charAt(left - 1) == '0' && photo.charAt(left) == '1' && photo.charAt(right) == '0') mid++;
      }
    }
    for (int i = 0; i < consec; i++) res += 2;
    res += mid;
    return res;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      String photo = br.readLine();
      System.out.println(countChanges(photo));
    }
  }
}
