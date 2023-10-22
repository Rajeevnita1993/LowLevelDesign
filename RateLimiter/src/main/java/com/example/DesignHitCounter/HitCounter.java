package com.example.DesignHitCounter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    // O(1) time as inserting in queue takes constant time
    public void  hit(int timestamp) {
        hits.offer(timestamp);
    }

    // O(Query * n) time
    // O(n) space for queue
    public int getHits(int timestamp) {
        while (!hits.isEmpty() && timestamp - hits.peek() >= 300) {
            hits.poll();
        }
        return hits.size();

    }
}
