package com.example.RateLimiter.LoggerRateLimiter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// O(1) time | O(n) space
public class LoggerLimiter {

    private int TIMEOUT = 10;
    Map<String, Integer> messageToExpiry;

    LoggerLimiter() {
        messageToExpiry = new HashMap<>();

    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if (messageToExpiry.containsKey(message) && messageToExpiry.get(message) > timestamp) {
            return false;
        }
        messageToExpiry.put(message, timestamp + TIMEOUT);
        return true;

    }
}
