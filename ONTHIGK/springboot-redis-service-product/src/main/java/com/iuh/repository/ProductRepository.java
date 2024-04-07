package com.iuh.repository;

import com.iuh.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<String, Product> {
}
