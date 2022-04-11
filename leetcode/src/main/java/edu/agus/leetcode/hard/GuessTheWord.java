package edu.agus.leetcode.hard;

import java.util.ArrayList;
import java.util.Random;

//todo: this is one of the hardest analysis based on probabilities, repeat
// https://leetcode.com/problems/guess-the-word/discuss/556075/how-to-explain-to-interviewer-843-guess-the-word
// https://www.youtube.com/watch?v=5hWmbr62K10
public class GuessTheWord {
  interface Master {
    public int guess(String word);
  }

  Random rand = new Random();

  int matches(String w1, String w2) {
    int count = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) == w2.charAt(i)) count++;
    }
    return count;
  }

  public void findSecretWord(String[] wordlist, Master master) {
    ArrayList<String> candidates = new ArrayList();
    for (String word : wordlist) candidates.add(word);
    for (int i = 0; i < 10; i++) {
      int idx = rand.nextInt(candidates.size());
      String candidate = candidates.get(idx);
      int guess = master.guess(candidate);

      if (guess == 6) break;
      ArrayList<String> newCandidates = new ArrayList();
      for (String s : candidates) {
        if (!s.equals(candidate) && matches(candidate, s) == guess) {
          newCandidates.add(s);
        }
      }
      candidates = newCandidates;
    }
  }
}
