package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
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
    public ProductResponseDTO getProductById(int id) {
        String getAllProductURL="https://fakestoreapi.com/products/" +id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse=restTemplate.getForEntity(getAllProductURL, ProductResponseDTO.class);
        return productResponse.getBody();
        //return null;
    }

    @Override
    public ProductListResponseDTO GetAllProducts() {
        String getAllProductUrl="https://fakestoreapi.com/products";
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> ProductResponseArray =restTemplate.getForEntity(getAllProductUrl, ProductResponseDTO[].class);
        ProductListResponseDTO responseListDTO =new ProductListResponseDTO();
        for(ProductResponseDTO productResponseDTOs :ProductResponseArray.getBody())
        {
          responseListDTO.getProducts().add(productResponseDTOs);
        }

        return responseListDTO;


       // return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        String createProductUrl="https://fakestoreapi.com/products";
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse=restTemplate.postForEntity(createProductUrl,productRequestDTO, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {
        String deleteProductURL="https://fakestoreapi.com/products/" +id;
        RestTemplate restTemplate=restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
        return true;
    }


}
