package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.entity.Product;



public interface ProductRepository extends JpaRepository<Product,Integer> {

}
