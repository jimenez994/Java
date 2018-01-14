package com.zeus.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zeus.ProductsAndCategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
