package com.zeus.ProductsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zeus.ProductsAndCategories.models.Category;
import com.zeus.ProductsAndCategories.services.CategoryServices;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	private CategoryServices categoryServices;
	
	public CategoryController(CategoryServices categoryServices) {
		this.categoryServices = categoryServices;
	}
	
	@RequestMapping("/new")
	public String createCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	@PostMapping("/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category,BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			categoryServices.addCategory(category);
			return "redirect:/";
		}
	}

}
