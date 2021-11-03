package my.compary.restaurant;

import my.compary.restaurant.infra.AbstractFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Stateless
public class ProductRepositoryJPA extends AbstractFacade<Product> implements ProductRepository {

    private static final Logger LOGGER = Logger.getLogger(ProductRepositoryJPA.class.getName());

    @PersistenceContext(unitName = "JPADatasourceExamplePU")
    private EntityManager entityManager;

    public ProductRepositoryJPA() {
        super(Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Collection<Product> getAll() {
        return super.findAll();
    }

    @Override
    public Product save(Product product) {
        Objects.requireNonNull(product, "A product is required");
        if (Objects.nonNull(product.getId())) {
            getEntityManager().merge(product);
        } else {
            getEntityManager().persist(product);
        }
        LOGGER.info("The data was updated: " + product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        LOGGER.info("Finding the item by id: " + id);
        return Optional.ofNullable(super.find(id));
    }

    @Override
    public void deleteById(Long id) {
        Optional<Product> item = findById(id);
        item.ifPresent(super::remove);
    }
}
