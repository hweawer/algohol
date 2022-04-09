package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
  public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    Map<Character, Integer> lettersSecret = new HashMap();
    Map<Character, Integer> lettersGuess = new HashMap();
    for (int i = 0; i < guess.length(); i++) {
      char guessChar = guess.charAt(i);
      if (secret.charAt(i) == guessChar) {
        bulls++;
      } else {
        int v = lettersSecret.getOrDefault(secret.charAt(i), 0) + 1;
        lettersSecret.put(secret.charAt(i), v);
        v = lettersGuess.getOrDefault(guessChar, 0) + 1;
        lettersGuess.put(guessChar, v);
      }
    }

    for (Map.Entry<Character, Integer> en : lettersGuess.entrySet()) {
      char letter = en.getKey();
      if (lettersSecret.containsKey(letter)) {
        cows += Math.min(lettersSecret.get(letter), en.getValue());
      }
    }

    return bulls + "A" + cows + "B";
  }
}
