package my.compary.cdi.demo;

import java.util.Optional;

public class ProductionProductRepository implements ProductRepository {
    @Override
    public void save(Product product) {
        throw new UnsupportedOperationException("We should not use a production env to test");
    }

    @Override
    public Optional<Product> findById(Long id) {
        throw new UnsupportedOperationException("We should not use a production env to test");
    }

    @Override
    public boolean hasStock(Long id) {
        throw new UnsupportedOperationException("We should not use a production env to test");
    }

    @Override
    public String toString() {
        return "ProductionProductRepository{}";
    }
}
