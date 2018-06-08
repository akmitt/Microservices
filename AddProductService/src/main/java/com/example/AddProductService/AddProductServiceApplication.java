package com.example.AddProductService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class AddProductServiceApplication {

	@Value("${service.application.instance}")
	private String instance;
	@Autowired
	private AddProductService service;
	public static void main(String[] args) {
		SpringApplication.run(AddProductServiceApplication.class, args);
	}
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Products> message(@PathVariable String id)
	{
		 System.out.println(id);
		 Products p = new Products();
		 p.setName("test");
		 p.setType("stationary");
		 ArrayList<Products> list = new ArrayList<>();
		 list.add(p);
		 service.getProducts();
		 return new ResponseEntity<>(p,HttpStatus.OK);
	}
}
