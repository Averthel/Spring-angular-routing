package pl.ave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ave.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
