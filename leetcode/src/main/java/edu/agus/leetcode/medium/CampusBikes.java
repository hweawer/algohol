package edu.agus.leetcode.medium;

import java.util.*;

public class CampusBikes {
  class DistanceWorkerBike implements Comparable<DistanceWorkerBike> {
    int distance;
    int worker;
    int bike;

    DistanceWorkerBike(int dist, int w, int b) {
      this.distance = dist;
      this.worker = w;
      this.bike = b;
    }

    public int compareTo(DistanceWorkerBike a) {
      int cmp = Integer.compare(this.distance, a.distance);
      if (cmp != 0) return cmp;
      cmp = Integer.compare(this.worker, a.worker);
      if (cmp != 0) return cmp;
      cmp = Integer.compare(this.bike, a.bike);
      return cmp;
    }
  }

  int distance(int[] worker, int[] bike) {
    return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
  }

  public int[] assignBikes(int[][] workers, int[][] bikes) {
    List<DistanceWorkerBike> all = new ArrayList();
    for (int i = 0; i < workers.length; i++) {
      for (int j = 0; j < bikes.length; j++) {
        int dist = distance(workers[i], bikes[j]);
        all.add(new DistanceWorkerBike(dist, i, j));
      }
    }
    Collections.sort(all);
    Set<Integer> workersVisited = new HashSet();
    Set<Integer> bikesVisited = new HashSet();
    int[] res = new int[workers.length];
    for (int i = 0; i < all.size(); i++) {
      int worker = all.get(i).worker;
      int bike = all.get(i).bike;
      if (!workersVisited.contains(worker) && !bikesVisited.contains(bike)) {
        res[worker] = bike;
        workersVisited.add(worker);
        bikesVisited.add(bike);
      }
    }
    return res;
  }
}
