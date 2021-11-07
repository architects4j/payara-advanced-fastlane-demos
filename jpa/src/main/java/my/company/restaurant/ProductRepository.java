package my.company.restaurant;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {
    Collection<Product> getAll();

    Product save(Product item);

    Optional<Product> findById(Long id);

    void deleteById(Long id);
}
