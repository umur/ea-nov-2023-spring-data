package miu.ea.controller;

import miu.ea.payload.ProductDto;
import miu.ea.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Combination of @Controller and @ResponseBody annotations
@RequestMapping("/api/products") // Base URL for product REST API
public class ProductController {

    private final ProductService productService; // Autowiring ProductService Bean

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

      /*
    Implement CRUD operations for the domains.*/

    // Get all products REST API
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    // create product REST api
    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }



} // End of ProductController class.
