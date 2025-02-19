package com.ronaldosantos.dscomerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ronaldosantos.dscomerce.dto.ProductDTO;
import com.ronaldosantos.dscomerce.entities.Product;
import com.ronaldosantos.dscomerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	//Buscando registro por Id
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Product product = repository.findById(id).get();
		return new ProductDTO(product);
	}
	
	//Buscando todos os registros do banco
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pagealbe ) {
		Page<Product> result = repository.findAll(pagealbe);
		return result.map(x -> new ProductDTO(x));
	}

}
