package com.ecommerce.controller;

import com.ecommerce.dto.request.ProductRequestDTO;
import com.ecommerce.dto.response.ProductResponseDTO;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/products")
    public class ProductController {
        @Autowired
        private ProductService productService;

        //CREATE
        @PostMapping
        public ResponseEntity<ProductResponseDTO>createProduct(@RequestBody ProductRequestDTO requestDTO)
        {
            ProductResponseDTO response= productService.createProduct(requestDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);

        }

        //GET ALL
        @GetMapping
    public ResponseEntity<List<ProductResponseDTO>>getAllProducts()
        {
            List<ProductResponseDTO> products=productService.getAllProducts();

            return ResponseEntity.ok(products);

        }


        //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id)
    {
        ProductResponseDTO product= productService.getProductById(id);

        return ResponseEntity.ok(product);

    }
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO requestDTO)
    {
        ProductResponseDTO updated= productService.updateProduct(id, requestDTO);
        return ResponseEntity.ok(updated);

    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable Long id){
            productService.deleteProduct(id);
            return ResponseEntity
                    .ok("Product Deleted Successfully");
    }




}