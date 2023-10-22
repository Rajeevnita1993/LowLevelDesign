package com.example.RateLimiter.ApiRateLimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimit {

    int rateLimit;
    Map<String, LinkedList<Request>> userRequestMap;

    public RateLimit(int limit) {
        this.rateLimit = limit;
        userRequestMap = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(String user, Instant timestamp) {
        if (!userRequestMap.containsKey(user)) {
            return addNewUser(user);
        } else {
            if (getTotalElapsedRequests(user) < rateLimit) {
                LinkedList<Request> requests = userRequestMap.get(user);
                requests.add(new Request(timestamp, 1));
                userRequestMap.put(user, requests);
                return true;
            } else {
                boolean actionTaken = false;
                for (int i = 0; i < userRequestMap.get(user).size(); i++) {
                    Duration duration = Duration.between(userRequestMap.get(user).get(i).getTimestamp(), timestamp);
                    //System.out.println("Duration: " +duration.getSeconds());
                    if (duration.getSeconds() >= 60) {
                        userRequestMap.get(user).remove(i);
                        actionTaken = true;
                    } else {
                        break;
                    }
                }

                if (actionTaken) {
                    LinkedList<Request> requests = userRequestMap.get(user);
                    requests.add(new Request(timestamp, 1));
                    userRequestMap.put(user, requests);
                    return true;
                }
            }
        }

        return false;
    }

    private boolean addNewUser(String user) {
        LinkedList<Request> requests = new LinkedList<>();
        requests.add(new Request(Instant.now(), 1));
        userRequestMap.put(user, requests);
        System.out.println("New user added !!" + user);
        return true;
    }

    private int getTotalElapsedRequests(String user) {
        return userRequestMap.get(user).stream().mapToInt(Request::getCount).sum();
    }

}
