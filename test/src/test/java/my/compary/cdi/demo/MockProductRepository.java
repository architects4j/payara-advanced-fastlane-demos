package my.compary.cdi.demo;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.interceptor.Interceptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Default
@Priority(Interceptor.Priority.APPLICATION)
@ApplicationScoped
public class MockProductRepository implements ProductRepository {

    private final Map<Long, Product> data;

    public MockProductRepository() {
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
}
