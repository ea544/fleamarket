package org.fleamarket.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.fleamarket.product.model.Product;
import org.fleamarket.product.service.ProductService;
import org.fleamarket.product.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductValidator productValidator;

	// @Autowired
	// Validator validator;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// binder.setValidator(validator);
		binder.addValidators(productValidator);
	}

	class ProductProxy{
		Integer id;
		List<String> photos = new ArrayList<String>();
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getId() {
			return id;
		}
		public void setPhotos(List<String> photos) {
			this.photos = photos;
		}
		public List<String> getPhotos(){
			return photos;
		}
	}
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
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "productForm";
		}
		Product prod = productService.saveProduct(product);
		Integer id = prod.getId();
		// return "redirect:/products/photosForm/" + id;
		return "redirect:/products/productProfile/" + id;
	}
	
	// /**
	// * Displays the form to upload photos
	// *
	// * @return
	// */
	// @RequestMapping(value = "/photosForm/{id}", method = RequestMethod.GET)
	// public String showPhotosForm(@PathVariable("id")Integer id, ModelMap model) {
	// ProductProxy product = new ProductProxy();
	// product.setId(id);
	// model.addAttribute("productProxy", product);
	// return "photosForm";
	// }
	//
	// /**
	// * Save a Product
	// *
	// * @param product
	// * @param model
	// * @return
	// */
	// @RequestMapping(value = "/photosForm", method = RequestMethod.POST)
	// public String savePhotos(
	// @RequestParam("photos") MultipartFile[] photos,
	// @RequestParam("id") Integer id){
	// //Check there are files attached and upload them
	// Product product = productService.getProduct(id);
	// System.out.println("The id is "+id);
	// try {
	// if( photos.length > 0) {
	// for( MultipartFile f:photos ) {
	// System.out.println(f.getOriginalFilename());
	// // try {
	// // productService.addPhoto(id, f);
	// // }
	// // catch(FleaMarketException e) {
	// // return "redirect:/products/productProfile/"+id;
	// // }
	// }
	// }
	// }
	// catch(Exception e) {
	// System.out.println("We faced some exception "+e.getClass().toString());
	//
	// e.printStackTrace();
	// }
	// productService.updateProduct(product);
	// return "redirect:/products/productProfile/"+id;
	// }

	/**
	 * Product profile
	 */
	@RequestMapping(value = "/productProfile/{id}", method = RequestMethod.GET)
	public String productProfile(@PathVariable Integer id, ModelMap model) {
		Product product = productService.getProductWithPhotos(id);
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
