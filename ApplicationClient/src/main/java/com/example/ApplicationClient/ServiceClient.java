package com.example.ApplicationClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "unknown")
	public Products getProduct() {
		return restTemplate.getForObject("http://ADD-PRODUCT-SERVICE/getProduct/123", Products.class);
	}

	public Products unknown() {
		Products c= new Products();
		c.setName("No product found");
		return c;
	}

}
