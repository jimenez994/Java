package com.zeus.ProductsAndCategories.services;

import java.util.ArrayList;

import com.zeus.ProductsAndCategories.models.Category;
import com.zeus.ProductsAndCategories.repositories.CategoryRepository;

public class CategoryServices {
	
	private CategoryRepository categoryRepository;
	public CategoryServices(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public ArrayList<Category> getAll(){
		return categoryRepository.findAll();
	}
	public Category findCategory(Long id) {
		return categoryRepository.findOne(id);
	}
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

}
