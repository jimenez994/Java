package com.zeus.ProductsAndCategories.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zeus.ProductsAndCategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	ArrayList<Category> findAll();
	List<Category> findByNameNotIn(List<String> name);
}
