package com.scaler.EcomProductService.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class ProductListResponseDTO {
    List<ProductResponseDTO> products;

    public ProductListResponseDTO() {
        //this.products = products;
        this.products=new ArrayList<>();
    }
}
