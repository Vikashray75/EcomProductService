package com.scaler.EcomProductService.controller;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductRequestDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class productController {

/* // field injection
  @Autowired
  @Qualifier("fakeStoreProductService")
    private ProductService productService;

 */

  private final ProductService productService;

  public productController(@Qualifier("fakeStoreProductService") ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products/{id}")
  public ResponseEntity getProductFromId(@PathVariable("id") int id)
  {
    ProductResponseDTO response=productService.getProductById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/products")
    public ResponseEntity GetAllProducts()
  {
    ProductListResponseDTO response=productService.GetAllProducts();

    return ResponseEntity.ok(response);
  }

  @PostMapping("/products")
  public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO)
  {
    ProductResponseDTO productResponse = productService.createProduct(productRequestDTO);
    return ResponseEntity.ok(productResponse);
  }


  /*  public ResponseEntity getAllProducts()
  {
      productResponseDTO p1=new productResponseDTO();
      p1.setId(1);
      p1.setTitle("iPhone 13");
      p1.setPrice(46000);
      p1.setCategory("Mobiles");
      p1.setDescription("iphone 13");
      p1.setImage("http//google.com/images/iphone13");

      productResponseDTO p2=new productResponseDTO();
      p2.setId(2);
      p2.setTitle("MACBOOK");
      p2.setPrice(99000);
      p2.setCategory("Laptops");
      p2.setDescription("Macbook wih A2 chip");
      p2.setImage("htps//gogle.com/Macbook");

      List<productResponseDTO> products = Arrays.asList(p1,p2);
      return ResponseEntity.ok(products);
  }

   */

}
