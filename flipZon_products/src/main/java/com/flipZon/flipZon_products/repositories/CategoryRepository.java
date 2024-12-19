package com.flipZon.flipZon_products.repositories;

import com.flipZon.flipZon_products.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
