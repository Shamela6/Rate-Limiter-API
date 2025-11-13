/**
 * 
 */
package com.example.rateLimiter.filter;

import java.io.IOException;
import java.time.Duration;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;

/**
 * 
 */
public class RateLimiterFilter implements Filter {
	
	private final Bucket bucket;
	
	public RateLimiterFilter() {
		//5 requests per minute
		Bandwidth limit = Bandwidth.classic(5, Refill.intervally(5, Duration.ofMinutes(1)));
		this.bucket = Bucket.builder().addLimit(limit).build();
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Invoking the filter");
		if(bucket.tryConsume(1)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setStatus(429);
			httpResponse.getWriter().write("Too many requests, please again later");
		}
	}

}
