package com.zeus.ProductsAndCategories.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.zeus.ProductsAndCategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	ArrayList<Category> findAll();
}
