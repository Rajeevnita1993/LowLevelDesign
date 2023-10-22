package com.example.RateLimiter.LoggerRateLimiter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Logger {

    LinkedHashMap<String, Integer> msgCache;

    public Logger() {
        int initialCapacity = 100;
        msgCache = new LinkedHashMap<>(initialCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > initialCapacity;
            }
        };
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        if(!msgCache.containsKey(message)) {
            msgCache.put(message, timestamp);
            return true;
        }

        if(timestamp - msgCache.get(message) >= 10) {
            msgCache.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}
