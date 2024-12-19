package com.flipZon.flipZon_products.repositories;

import com.flipZon.flipZon_products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
