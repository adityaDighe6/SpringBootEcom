package com.springecom.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springecom.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
