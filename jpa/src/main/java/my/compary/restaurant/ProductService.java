package my.compary.restaurant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    @Inject
    private ProductMapper mapper;

    public Collection<ProductDTO> getAll() {
        return repository.getAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Optional<ProductDTO> findById(Long id) {
        return this.repository.findById(id).map(mapper::toDTO);
    }

    public ProductDTO save(ProductDTO dto) {
        Product product = mapper.toEntity(dto);
        return mapper.toDTO(this.repository.save(product));
    }

    public void deleteById(Long id) {

    }
}
