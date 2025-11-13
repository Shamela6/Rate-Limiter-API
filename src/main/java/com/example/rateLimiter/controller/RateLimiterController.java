/**
 * 
 */
package com.example.rateLimiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * 
 */
@RestController
public class RateLimiterController {

	@GetMapping("/api/ratelimiter")
	public String rateLimiter() {
		return "Rate Limiter API";
	}
}
