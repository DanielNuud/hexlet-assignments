package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findByPriceGreaterThanEqual(Integer price);
    List<Product> findByPriceLessThanEqual(Integer price);
    List<Product> findByTitleOrderByPrice(String title);
    List<Product> findByTitleOrderByPriceDesc(String title);

    List<Product> findByPriceBetween(Integer startPrice, Integer endPrice);
    // END
}
