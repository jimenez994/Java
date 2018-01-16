package com.zeus.ProductsAndCategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zeus.ProductsAndCategories.models.Category;
import com.zeus.ProductsAndCategories.models.Product;
import com.zeus.ProductsAndCategories.repositories.CategoryRepository;

@Service
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
	public List<Category> listAvailableCategories(Product product){
		List<String> names = new ArrayList<String>();
		List<Category> current = product.getCategories();
		if(current.isEmpty()) {
			names.add("");
		}else {
			for (Category cate: current) {
				names.add(cate.getName());
			}
		}
		List<Category> categories =  categoryRepository.findByNameNotIn(names);
		return categories;
	}

}
