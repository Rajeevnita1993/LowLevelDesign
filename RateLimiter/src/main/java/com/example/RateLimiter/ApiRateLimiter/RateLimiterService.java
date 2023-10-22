package com.example.RateLimiter.ApiRateLimiter;

public class RateLimiterService {

    public static void main(String[] args) {
        RateLimiterService rateLimiterService = new RateLimiterService();
        int limit = 5;
        RateLimit rateLimit = new RateLimit(limit);
        new RateLimitHelper("UserA", rateLimit).start();
        new RateLimitHelper("UserB", rateLimit).start();
    }
}
