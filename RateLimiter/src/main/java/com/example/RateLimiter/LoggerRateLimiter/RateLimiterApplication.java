package com.example.RateLimiter.LoggerRateLimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterApplication.class, args);

//		Logger logger = new Logger();
//
//		System.out.println(logger.shouldPrintMessage(1, "foo"));
//		System.out.println(logger.shouldPrintMessage(3, "bar"));
//		System.out.println(logger.shouldPrintMessage(5, "xyz"));
//		System.out.println(logger.shouldPrintMessage(10, "foo"));
//		System.out.println(logger.shouldPrintMessage(12, "foo"));
//		System.out.println(logger.shouldPrintMessage(12, "bar"));
	}

}
