package com.flipZon.flipZon_products.services;

import com.flipZon.flipZon_products.entities.Category;
import com.flipZon.flipZon_products.entities.Product;
import com.flipZon.flipZon_products.repositories.CategoryRepository;
import com.flipZon.flipZon_products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

//    public Product createProduct(Product product){
//        return productRepository.save(product);
//    }
public Product createProduct(Product product, Long categoryId) {
    // Fetch the category from the database
    Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

    // Associate the product with the fetched category
    product.setCategory(category);

    // Save and return the product
    return productRepository.save(product);
}



    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product unavailable"));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        return productRepository.save(product);
    }




    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
