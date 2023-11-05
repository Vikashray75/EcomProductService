package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.productResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public productResponseDTO getProductById(int id) {
        String getAllProductURL="https://fakestoreapi.com/products/" +id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<productResponseDTO> productResponse=restTemplate.getForEntity(getAllProductURL, productResponseDTO.class);
        return productResponse.getBody();
        //return null;
    }
}
