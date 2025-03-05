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

    @PostMapping("add-all-products")
    public List<Product> saveAllProduct (@RequestBody List <Product> products) {
        productRepository.saveAll(products); // Tagataustal: insert values into pictures
        return productRepository.findAll(); // Tagataustal: select * from pictures;
    }

    //@RequestParam  localhost:8090/product?id=5
    //@PathVariable   localhost:8090/product/5
    @GetMapping("product")
    public Product getProduct (@RequestParam Long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @PutMapping("products")
    public List<Product> editProduct (@RequestBody Product product) {
        if (productRepository.findById(product.getId()).isPresent()) {
            productRepository.save(product);
        }
        productRepository.save(product);
        return productRepository.findAll();
    }

    // localhost:8090/products-by-category?category=electronics
    @GetMapping("products-by-category")
    public List <Product> getProductByCategory(@RequestParam String category) {
        return productRepository.findByCategory(category);
    }

    @DeleteMapping("products")
    public List <Product> deleteProduct (@RequestParam Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
}
