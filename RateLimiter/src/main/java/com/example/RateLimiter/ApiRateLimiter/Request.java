package com.example.RateLimiter.ApiRateLimiter;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Request {
    private Instant timestamp;
    private int count;

    public Request(Instant timestamp, int count) {
        this.timestamp = timestamp;
        this.count = count;
    }
}
