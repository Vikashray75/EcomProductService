package com.scaler.EcomProductService.service;

import com.scaler.EcomProductService.Client.FakeStoreAPIClient;
import com.scaler.EcomProductService.Exception.ProductNotFoundException;
import com.scaler.EcomProductService.dto.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.scaler.EcomProductService.Mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.EcomProductService.Mapper.ProductMapper.productResponseToFakeStoreProductResponse;
import static com.scaler.EcomProductService.Mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.scaler.EcomProductService.Util.ProductUtils.isNull;
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException{
        FakeStoreProductResponseDto productById = fakeStoreAPIClient.getProductById(id);
        if(isNull(productById))
        {
            throw new ProductNotFoundException("Product not found with id:"+id);
        }
        return fakeStoreProductResponseToProductResponse(productById);
//        String getAllProductURL="https://fakestoreapi.com/products/" +id;
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<ProductResponseDTO> productResponse=restTemplate.getForEntity(getAllProductURL, ProductResponseDTO.class);
//        return productResponse.getBody();

    }

    @Override
    public ProductListResponseDTO GetAllProducts() {

        List<FakeStoreProductResponseDto>fakeStoreProductResponseDtos=fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productListResponseDTO=new ProductListResponseDTO();
        for(FakeStoreProductResponseDto fakeStoreProductResponseDto:fakeStoreProductResponseDtos)
        {
            productListResponseDTO.getProducts().add(fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDto));
        }

       return productListResponseDTO;


       // return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        FakeStoreProductRequestDto fakeStoreProductRequestDto=productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDto fakeStoreProductResponse = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDto);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponse);

//        String createProductUrl="https://fakestoreapi.com/products";
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<ProductResponseDTO> productResponse=restTemplate.postForEntity(createProductUrl,productRequestDTO, ProductResponseDTO.class);
//        return productResponse.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }


}
