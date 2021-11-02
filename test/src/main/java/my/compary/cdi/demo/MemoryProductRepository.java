package my.compary.cdi.demo;

import java.util.Optional;

public class MemoryProductRepository implements ProductRepository{
    @Override
    public void save(Product product) {
        throw new UnsupportedOperationException("It is not supported Yet");
    }

    @Override
    public Optional<Product> findById(Long id) {
        throw new UnsupportedOperationException("It is not supported Yet");
    }

    @Override
    public boolean hasStock(Long id) {
        throw new UnsupportedOperationException("It is not supported Yet");
    }
}
