package edu.agus.leetcode.hard;

import java.util.*;

//todo i am too
public class PalindromePairs {
  public class TrieNode {
    TrieNode[] children;            // the next characters in words.
    int wordIndex;                  // if current TrieNode is the end of a word, store the index of this word in words.

    // restIsPalindrome: rest of the current branch (substring) is a valid Palindrome substring.
    // e.g. abcll, then for c, its restIsPalindrome will store the index of the word "abcll";
    List<Integer> restIsPalindrome;

    public TrieNode() {
      children = new TrieNode[26];    // only consists of 26 lowercase English letters.
      wordIndex = -1;
      restIsPalindrome = new ArrayList<>();
    }
  }

  public class Trie {
    TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public Trie(String[] words) {
      this();

      // build trie from an array of words.
      for (int w = 0; w < words.length; w++) {
        TrieNode curNode = root;    // start from the root of the trie for each word.
        char[] chs = words[w].toCharArray();

        // build from the endIndex of each word, why?
        // e.g.
        // (1) xyzll | zyx; we build from end, then trie will be: l->l->z->y->x and x->y->z(z.wordIndex != -1)
        // then for each word we go from the root of trie, for xyzll, we found z.wordIndex != -1 and ll is a palindrome
        // then xyzllzyx will form a valid palindrome.

        // (2) llzyx | xyz or llllzyx | xyz; we build from the end, x->y->z->llll is palindrome
        // add curWordIndex into Z.restIsPalindrome List.
        // then when we are processing with xyz, we can find a branch in the trie: x->y->z
        // and we can add all the options in restIsPalindrome will form xyzllzyx, xyzllllzyx palindrome paris.

        // (3) xyz | zyx => easy to know.
        for (int i = chs.length - 1; i >= 0; i--) {
          if (isPalindrome(chs, 0, i))
            curNode.restIsPalindrome.add(w);

          int ch = chs[i] - 'a';
          if (curNode.children[ch] == null)
            curNode.children[ch] = new TrieNode();

          curNode = curNode.children[ch];
        }

        curNode.wordIndex = w;
      }
    }
  }

  public boolean isPalindrome(char[] chs, int left, int right) {
    while (left < right) {
      if (chs[left++] != chs[right--])
        return false;
    }

    return true;
  }

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> resultList = new ArrayList<>();

    // first put each word into the trie.
    Trie trie = new Trie(words);

    for (int i = 0; i < words.length; i++)
      searchPairs(resultList, trie.root, words[i], i);

    return resultList;
  }

  private void searchPairs(List<List<Integer>> resultList, TrieNode root, String word, int curIndex) {
    TrieNode curNode = root;
    char[] curWord = word.toCharArray();
    int len = curWord.length;

    for (int c = 0; c < curWord.length; c++) {
      // inside the loop,check if the rest of the word is palindrome.
      // xyzll <-> zyx; because we build each word in trie from end index of a word.
      // so if we do found the x -> y -> z branch with TrieNode z.wordIndex != -1(zyx is a word), and "ll" is palindrome
      // then a valid palindrome pair is formed(xyzllzyx);
      if (curNode.wordIndex != -1 && isPalindrome(curWord, c, len - 1))
        resultList.add(Arrays.asList(curIndex, curNode.wordIndex));

      int childIndex = curWord[c] - 'a';

      if (curNode.children[childIndex] == null) return; // no further nodes.

      curNode = curNode.children[childIndex];
    }

    // the current branch did go to the bottom, meaning there is at least one word in words
    // which has a reversed substring of curword. e.g. (1) abcd <-> dcba; (2) Or: xyz <-> llzyx
    // (1) abcd <-> dcba.
    if (curNode.wordIndex != -1 && curNode.wordIndex != curIndex)
      resultList.add(Arrays.asList(curIndex, curNode.wordIndex));

    // (2) xyz <-> llzyx
    for (Integer firstIndex : curNode.restIsPalindrome)
      resultList.add(Arrays.asList(curIndex, firstIndex));
  }
}
