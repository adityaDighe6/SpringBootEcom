package com.springecom.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springecom.services.ProductService;
import com.springecom.models.Product;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//To get all the products
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	//To het a single product by passing id
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		 Product product = productService.getProductById(id);
		 
		 if(product.getId() != -1)
			 return new ResponseEntity<Product>(product, HttpStatus.OK);
		 else
			 return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	//To add a product
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
		
		Product savedProduct = null;
        try {
            savedProduct = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }	
	}
	
	//To fetch image using id
	@GetMapping("/product/{id}/image")
	public ResponseEntity<byte[]> getImageById(@PathVariable int id) {
		Product product = productService.getProductById(id);
		
		return new ResponseEntity<byte[]>(product.getImageData(),HttpStatus.OK);
	}
	
}
