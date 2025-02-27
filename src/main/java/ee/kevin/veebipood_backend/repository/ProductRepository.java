package ee.kevin.veebipood_backend.repository;

import ee.kevin.veebipood_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
