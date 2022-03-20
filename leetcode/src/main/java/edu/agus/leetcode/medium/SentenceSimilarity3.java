package edu.agus.leetcode.medium;

public class SentenceSimilarity3 {
  public boolean areSentencesSimilar(String sentence1, String sentence2) {
    String[] words1 = sentence1.split(" ");
    String[] words2 = sentence2.split(" ");

    String[] min = words1.length < words2.length ? words1 : words2;
    String[] max = words1.length > words2.length ? words1 : words2;
    if (words1.length == words2.length) {
      min = words1;
      max = words2;
    }
    int minLeft = 0, maxLeft = 0;
    int minRight = min.length - 1;
    int maxRight = max.length - 1;

    while (minLeft <= minRight) {
      if (min[minLeft].equals(max[maxLeft])) {
        minLeft++;
        maxLeft++;
      } else if (min[minRight].equals(max[maxRight])) {
        minRight--;
        maxRight--;
      } else return false;
    }
    return true;
  }

  public static void main(String[] args) {
    SentenceSimilarity3 ss = new SentenceSimilarity3();
    ss.areSentencesSimilar("My name is Haley", "My Haley");
  }
}
