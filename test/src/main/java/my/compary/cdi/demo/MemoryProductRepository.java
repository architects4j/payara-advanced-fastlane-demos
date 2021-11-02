package my.compary.cdi.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class MemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> data;

    public MemoryProductRepository() {
        this.data = new HashMap<>();
    }

    @Override
    public void save(Product product) {
        Objects.requireNonNull(product, "product is required");
        this.data.put(product.getId(), product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        Objects.requireNonNull(id, "id is required");
        return Optional.ofNullable(this.data.get(id));
    }

    @Override
    public boolean hasStock(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public String toString() {
        return "MemoryProductRepository{" +
                "data=" + data +
                '}';
    }
}
