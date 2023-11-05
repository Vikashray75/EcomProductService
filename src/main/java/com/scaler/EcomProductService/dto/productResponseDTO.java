package com.scaler.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class productResponseDTO {
    private int id;
    String title;
    double price;
    String category;
    String description;
    String image;
}
