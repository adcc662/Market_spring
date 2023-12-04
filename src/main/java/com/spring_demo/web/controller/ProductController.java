package com.spring_demo.web.controller;

import com.spring_demo.domain.Product;
import com.spring_demo.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;
import java.util.Optional;

@Tag(name = "Market API", description = "This is an example of one market place API to products")
@RestController
@RequestMapping("/products")
public class ProductController {



    @Autowired
    private ProductService productService;

    @Operation(
            summary = "Get all products from the shop",
            description = "Get all products such as you enter to the home in one web page.",
            tags = {"products", "get"})

    @GetMapping()
    public ResponseEntity<List<Product>> getAll(){

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }



    @Operation(
            summary = "Get one product for its id",
            description = "Get one product such as you select one product and shows its description and specifications",
            tags = {"products", "get"})
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Operation(
            summary = "Get one product from a specific category",
            description = "Suppose that you enter in one page and you want to select one product in a specific category",
            tags = {"products", "get"})
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Operation(
            summary = "Create one product",
            description = "Imagine that you are one admin in a web page, you can create one new product and add all characteristics",
            tags = {"products", "post"})
    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Delete one product",
            description = "Suppose you want to delete a product that you have nothing existence",
            tags = {"products", "delete"})
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if (productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
          return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
