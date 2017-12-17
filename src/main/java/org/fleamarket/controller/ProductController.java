package org.fleamarket.controller;

import org.fleamarket.domain.Product;
import org.fleamarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * This is the home page for products
	 */
	@RequestMapping(value = { "", "/product" }, method = RequestMethod.GET)
	public String redirectRoot() {
		return "product";
	}
	
	/**
	 * Save a Product
	 * 
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/productForm", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("vendor") Product product, ModelMap model) {
		Integer id = 0;
		try { 
			id = product.getId();
			productService.updateProduct(product);
		}
		catch(Exception e) {
			System.out.println("The is zero so we are creating");
			id = productService.createProduct(product);
		}
		return "redirect:/products/productProfile/"+id;
	}

	/**
	 * Product profile
	 */
	@RequestMapping(value = "/productProfile/{id}", method = RequestMethod.GET)
	public String productProfile(@PathVariable Integer id, ModelMap model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "productProfile";
	}
	
	/**
	 * Displays the product form
	 * 
	 * @return
	 */
	@RequestMapping(value = "/productForm", method = RequestMethod.GET)
	public String productForm(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("edit", false);
		return "productForm";
	}
	
	/**
	 * Displays the product form
	 * 
	 * @return
	 */
	@RequestMapping(value="/productForm/{id}", method = RequestMethod.GET)
	public String productEditForm(@PathVariable Integer id, ModelMap model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("edit", true);
		return "productForm";
	}
	
	/**
	 * Displays the product form
	 * 
	 * @return
	 */
	@RequestMapping(value="/productForm/{id}", method = RequestMethod.POST)
	public String productUpdate(@PathVariable Integer id, 
			@ModelAttribute("product")Product product) {
		productService.updateProduct(product);
		return "redirect:/products/productProfile/"+id;
	}
	
}
