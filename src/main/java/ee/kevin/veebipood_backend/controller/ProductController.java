package ee.kevin.veebipood_backend.controller;

import ee.kevin.veebipood_backend.entity.Picture;
import ee.kevin.veebipood_backend.entity.Product;
import ee.kevin.veebipood_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// RestController annab eriomadusi sellele klassile
@RestController
@CrossOrigin(origins = "http://localhost:5173") //TODO: Firebase aadress
public class ProductController {
    // Controllerid on front-endiga suhtlemiseks.
    // Nende sees on API otspunktid, mille poole front-end pöördub.

    @Autowired
    private ProductRepository productRepository;

    //localhost8090/products
    @GetMapping("products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("products")
    public List<Product> saveProduct (@RequestBody Product product) {
        productRepository.save(product); // Tagataustal: insert values into pictures
        return productRepository.findAll(); // Tagataustal: select * from pictures;
    }
}
