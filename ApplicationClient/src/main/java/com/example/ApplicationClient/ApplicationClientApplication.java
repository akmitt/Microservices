package com.example.ApplicationClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ApplicationClientApplication {

	@Autowired

	private RestTemplate restTemplate;
	@Autowired
    private ServiceClient serviceCLient;
	private EurekaClient eurekaClient;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationClientApplication.class, args);
	}

	@GetMapping("/getProduct/{id}")
	
	public ResponseEntity<Products> getProduct(@PathVariable String id) {
		/* RestTemplate restTemplate= restTemplateBuilder.build(); */
		/*
		 * System.out.println(eurekaClient); InstanceInfo
		 * info=eurekaClient.getNextServerFromEureka("ADD-PRODUCT-SERVICE",
		 * false); String url=info.getHomePageUrl(); String response=
		 * restTemplate.getForObject("http://ADD-PRODUCT-SERVICE",
		 * String.class);
		 */
		System.out.println(id);
		Products p= serviceCLient.getProduct(id);
	
		return  new ResponseEntity<>(p,HttpStatus.OK);

	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
