package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.Exception.ProductNotFoundException;
import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductListResponseDTO GetAllProducts();
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
}
