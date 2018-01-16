package com.zeus.ProductsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.ProductsAndCategories.models.Category;
import com.zeus.ProductsAndCategories.models.Product;
import com.zeus.ProductsAndCategories.services.CategoryServices;
import com.zeus.ProductsAndCategories.services.ProductServices;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private CategoryServices categoryServices;
	private ProductServices productServices;
	public ProductController(ProductServices productServices) {
		this.productServices = productServices;
		
	}
	@RequestMapping("/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			productServices.addProduct(product);
			return "redirect:/";
		}
	}
	@RequestMapping("/{id}")
	public String createProductCategory(Model model,@PathVariable("id") Long id) {
		model.addAttribute("categories", categoryServices.listAvailableCategories(productServices.findProduct(id)));
		model.addAttribute("product", productServices.findProduct(id));
		return "newPC.jsp";
	}
	
	@PostMapping("/{id}")
	public String addProductCategory(Model model, @PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
		Product product = productServices.findProduct(productId);
		Category category = categoryServices.findCategory(categoryId);
		product.getCategories().add(category);
		productServices.addProduct(product);
		return "redirect:/";
	}
	


}
