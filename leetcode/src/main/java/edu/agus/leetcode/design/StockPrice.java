package edu.agus.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class StockPrice {
  private HashMap<Integer, Integer> map;
  private TreeMap<Integer, Integer> tmap;
  private Integer maxTimestamp;

  public StockPrice() {
    this.map = new HashMap<>();
    this.tmap = new TreeMap<>();
    this.maxTimestamp = -1;
  }

  public void update(int timestamp, int price) {

    Integer prevPrice = map.get(timestamp);
    map.put(timestamp, price);

    if(prevPrice != null){
      tmap.put(prevPrice, tmap.get(prevPrice) - 1);
      if(tmap.get(prevPrice) == 0) tmap.remove(prevPrice);
    }

    tmap.put(price, tmap.getOrDefault(price, 0) + 1);

    // Update max time
    this.maxTimestamp = Math.max(maxTimestamp, timestamp);
  }

  public int current() {
    return map.get(this.maxTimestamp);
  }

  public int maximum() {
    return tmap.lastKey();
  }

  public int minimum() {
    return tmap.firstKey();
  }
}
