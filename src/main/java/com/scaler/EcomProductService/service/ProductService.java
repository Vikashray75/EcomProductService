package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.productResponseDTO;

public interface ProductService {

    productResponseDTO getProductById(int id);
}
