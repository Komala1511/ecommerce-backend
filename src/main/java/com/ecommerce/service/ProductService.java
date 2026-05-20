package com.ecommerce.service;

import com.ecommerce.dto.request.ProductRequestDTO;
import com.ecommerce.dto.response.ProductResponseDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
//import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    //CREATE

    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        //convert requestDTO to entity
        Product product = new Product();

        product.setName(requestDTO.getName());
        product.setDescription(requestDTO.getDescription());
        product.setPrice(requestDTO.getPrice());
        product.setQuantity(requestDTO.getQuantity());

        //save to DB
        Product savedProduct = productRepository.save(product);
        // convert Entity -> responseDTO and return

        return convertToResponseDTO(savedProduct);
    }


        //GET ALL
        public List<ProductResponseDTO> getAllProducts ()
        {
            List<Product> products = productRepository.findAll();

            return products.stream()
                    .map(this::convertToResponseDTO)
                    .collect(Collectors.toList());

        }
        //getby ID
        public ProductResponseDTO getProductById (Long Id)
        {
            Product product = productRepository.findById(Id)
                    .orElseThrow(() ->
                            new RuntimeException("Product not found with ID" + Id));

            return convertToResponseDTO(product);
        }

        //Update
        public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO)
        {

        //find existing product
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID" + id));

        //update fields
        product.setName(requestDTO.getName());
        product.setDescription(requestDTO.getDescription());
        product.setPrice(requestDTO.getPrice());
        product.setQuantity(requestDTO.getQuantity());

        //save updated product
        Product updatedProduct = productRepository.save(product);

        //convert->ResponseDTOand return
        return convertToResponseDTO(updatedProduct);

    }
    //delete
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

        //convert Entity-> ResponseDTO
        private ProductResponseDTO convertToResponseDTO(Product product)
        {
            ProductResponseDTO responseDTO=new ProductResponseDTO();

            responseDTO.setId(product.getId());
            responseDTO.setName(product.getName());
            responseDTO.setDescription(product.getDescription());
            responseDTO.setPrice(product.getPrice());
            responseDTO.setQuantity(product.getQuantity());

            return responseDTO;


        }
    }

