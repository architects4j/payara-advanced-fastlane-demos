package my.compary.restaurant;

import java.util.Collection;
import java.util.Optional;

public interface RestaurantRepository {
    Collection<Product> getAll();

    Product save(Product item);

    Optional<Product> findById(String id);

    void deleteById(String id);
}
