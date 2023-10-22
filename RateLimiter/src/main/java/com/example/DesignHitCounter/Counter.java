package com.example.DesignHitCounter;

import java.util.Deque;
import java.util.LinkedList;

public class Counter {

    class Pair {
        int timestamp;
        int count;

        Pair(int timestamp, int count) {
            this.timestamp = timestamp;
            this.count = count;
        }
    }

    Deque<Pair> hits;
    int total;

    Counter() {
        hits = new LinkedList<>();
        total = 0;
    }

    // O(1) time
    public void hit(int timestamp) {
        if (hits.isEmpty() || hits.getLast().timestamp != timestamp) {
            hits.offerLast(new Pair(timestamp, 1));
        } else {
            int prevCount = hits.getLast().count;
            hits.pollLast();
            hits.offerLast(new Pair(timestamp, prevCount + 1));
        }
        total++;
    }

    // O(n) time
    // O(n) space
    public int getHits(int timestamp) {

        while (!hits.isEmpty() && timestamp - hits.peekFirst().timestamp >= 300) {
            total -= hits.getFirst().count;
            hits.pollFirst();
        }
        return total;
    }
}
