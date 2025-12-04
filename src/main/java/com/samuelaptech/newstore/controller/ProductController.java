package com.samuelaptech.newstore.controller;

import com.samuelaptech.newstore.dto.ProductDTO;
import com.samuelaptech.newstore.entities.Product;
import com.samuelaptech.newstore.mappers.ProductMapper;
import com.samuelaptech.newstore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDTO> getAllProducts(@RequestParam(name = "categoryId", required = false) Byte categoryId) {

        List<Product> products;
        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findAllWithCategory();
        }
        return products.stream().map(productMapper::productToProductDTO).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.productToProductDTO(product));
    }
}
