package com.springecom.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springecom.models.Product;
import com.springecom.repos.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	//To get all the products
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	//To get a single product by id
	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(new Product(-1));
	}
	
	//To add a product
	public Product addProduct(Product product, MultipartFile image) throws IOException {
		
		product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
		return productRepo.save(product);
	}
	
	//To update the product
	public Product updateProduct(Product product, MultipartFile image) throws IOException {
		
		product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
		return productRepo.save(product);
	}
	
	//To delete the product
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}
	
	//To search the products
	public List<Product> searchProducts(String keyword) {
		return productRepo.searchProducts(keyword);
	}
}
