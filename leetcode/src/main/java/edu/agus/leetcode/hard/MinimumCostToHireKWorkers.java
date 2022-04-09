package edu.agus.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
  public class Worker implements Comparable<Worker> {
    int wage;
    int quality;

    Worker(int wage, int quality) {
      this.wage = wage;
      this.quality = quality;
    }

    double ratio() {
      return (double) wage / quality;
    }

    public int compareTo(Worker other) {
      return Double.compare(ratio(), other.ratio());
    }
  }

  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    int n = quality.length;
    Worker[] workers = new Worker[n];
    for(int i = 0; i < n; i++) {
      workers[i] = new Worker(wage[i], quality[i]);
    }
    Arrays.sort(workers);
    double ans = Double.MAX_VALUE;
    int rollingSum = 0;
    PriorityQueue<Integer> pq = new PriorityQueue();
    for(Worker worker : workers) {
      pq.add(-worker.quality);
      rollingSum += worker.quality;
      if (pq.size() > k) {
        rollingSum += pq.poll();
      }
      if (pq.size() == k) {
        ans = Math.min(ans, worker.ratio() * rollingSum);
      }
    }
    return ans;
  }
}
