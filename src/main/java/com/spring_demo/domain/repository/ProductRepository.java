package com.spring_demo.domain.repository;
import com.spring_demo.domain.Product;

import java.util.List;
import java.util.Optional;
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    void delete(int productId);



}
