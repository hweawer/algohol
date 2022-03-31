package edu.agus.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
  class Logger {
    Map<String, Integer> map = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
      if (map.containsKey(message)) {
        if (map.get(message) <= timestamp) {
          map.put(message, timestamp + 10);
          return true;
        } else return false;
      } else {
        map.put(message, timestamp + 10);
        return true;
      }
    }
  }
}
