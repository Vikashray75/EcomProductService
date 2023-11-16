package com.scaler.EcomProductService.Client;

import com.scaler.EcomProductService.dto.FakeStoreProductRequestDto;
import com.scaler.EcomProductService.dto.FakeStoreProductResponseDto;
import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Getter
@Setter
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDto createProduct(FakeStoreProductRequestDto fakeStoreProductRequestDto)
    {
        String createProductUrl="https://fakestoreapi.com/products";
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto> productResponse=restTemplate.postForEntity(createProductUrl,fakeStoreProductRequestDto,FakeStoreProductResponseDto.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDto getProductById(int id)
    {
        String getProduct ="https://fakestoreapi.com/products/" +id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto> productResponse=restTemplate.getForEntity(getProduct, FakeStoreProductResponseDto.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDto> getAllProducts()
    {
        String getAllProductUrl="https://fakestoreapi.com/products";
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto[]> ProductResponseArray =restTemplate.getForEntity(getAllProductUrl, FakeStoreProductResponseDto[].class);
        return List.of(ProductResponseArray.getBody());

    }

    public boolean deleteProduct(int id)
    {
        String deleteProductURL="https://fakestoreapi.com/products/" +id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
        return true;
    }
}
