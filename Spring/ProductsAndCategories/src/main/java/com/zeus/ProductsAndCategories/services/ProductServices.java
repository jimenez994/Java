package com.zeus.ProductsAndCategories.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.ProductsAndCategories.models.Category;
import com.zeus.ProductsAndCategories.models.Product;
import com.zeus.ProductsAndCategories.repositories.ProductRepository;

@Service
public class ProductServices {
	
	private ProductRepository productRepository;
	public ProductServices(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ArrayList<Product> getAll(){
		return productRepository.findAll();
		}
	public Product findProduct(Long id) {
		return productRepository.findOne(id);
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	

	public void addProductToCategory(Long id, Category category) {
		productRepository.findOne(id).getCategories().add(category);
	}

}
