package com.example.AddProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProductService {

	@Autowired
	private ProductRepository repo;

	public void getProducts() {
		Products p = new Products();
		p.setName("test");
		p.setType("stationary");
		repo.save(p);
	}

}
