package com.scaler.EcomProductService.Mapper;

import com.scaler.EcomProductService.dto.FakeStoreProductRequestDto;
import com.scaler.EcomProductService.dto.FakeStoreProductResponseDto;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;

public class ProductMapper {

    public static FakeStoreProductRequestDto productRequestToFakeStoreProductRequest(ProductRequestDTO productRequestDTO){
        FakeStoreProductRequestDto fakeStoreProductRequestDto=new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDto.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDto.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDto.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDto.setImage(productRequestDTO.getImage());
        return fakeStoreProductRequestDto;

    }
    public static FakeStoreProductResponseDto productResponseToFakeStoreProductResponse(ProductResponseDTO productResponseDTO){
        FakeStoreProductResponseDto fakeStoreProductResponseDto=new FakeStoreProductResponseDto();
        fakeStoreProductResponseDto.setId(productResponseDTO.getId());
        fakeStoreProductResponseDto.setCategory(productResponseDTO.getCategory());
        fakeStoreProductResponseDto.setTitle(productResponseDTO.getTitle());
        fakeStoreProductResponseDto.setPrice(productResponseDTO.getPrice());
        fakeStoreProductResponseDto.setImage(productResponseDTO.getImage());
        return fakeStoreProductResponseDto;

    }
    public static ProductResponseDTO fakeStoreProductResponseToProductResponse(FakeStoreProductResponseDto fakeStoreProductResponseDto){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setId(fakeStoreProductResponseDto.getId());
        productResponseDTO.setPrice(fakeStoreProductResponseDto.getPrice());
        productResponseDTO.setCategory(fakeStoreProductResponseDto.getCategory());
        productResponseDTO.setDescription(fakeStoreProductResponseDto.getDescription());
        productResponseDTO.setTitle(fakeStoreProductResponseDto.getTitle());
        productResponseDTO.setImage(fakeStoreProductResponseDto.getImage());
        return productResponseDTO;
    }
}
