package com.example.rateLimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.rateLimiter.filter.RateLimiterFilter;

@SpringBootApplication
public class RateLimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<RateLimiterFilter> filterLogging(){
		FilterRegistrationBean<RateLimiterFilter> register = new FilterRegistrationBean<>();
		register.setFilter(new RateLimiterFilter());
		register.addUrlPatterns("/api/*");
		return register;
	}

}
