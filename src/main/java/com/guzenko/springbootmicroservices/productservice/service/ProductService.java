package com.guzenko.springbootmicroservices.productservice.service;

import com.guzenko.springbootmicroservices.productservice.dto.ProductRequest;
import com.guzenko.springbootmicroservices.productservice.dto.ProductResponse;
import com.guzenko.springbootmicroservices.productservice.model.Product;
import com.guzenko.springbootmicroservices.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll().stream().map(product -> new ProductResponse(product.getId()
                , product.getName()
                , product.getDescription()
                , product.getPrice())).toList();
    }

//    private ProductResponse mapToProductResponse(Product product) {
//        return new ProductResponse().builder()
//                .id(product.getId())
//                .name(product.getName())
//                .description(product.getDescription())
//                .price(product.getPrice())
//                .build();
//    }
}
