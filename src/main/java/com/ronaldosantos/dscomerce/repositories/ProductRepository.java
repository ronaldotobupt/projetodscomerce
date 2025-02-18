package com.ronaldosantos.dscomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronaldosantos.dscomerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
