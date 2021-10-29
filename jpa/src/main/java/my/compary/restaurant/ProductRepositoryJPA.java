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
    public Product save(Product item) {
        Objects.requireNonNull(item, "An item is required");
        Optional<Product> itemOptional = findById(item.getName());
        if (itemOptional.isPresent()) {
            getEntityManager().merge(item);
        } else {
            getEntityManager().persist(item);
        }
        LOGGER.info("The data was updated: " + item);
        return item;
    }

    @Override
    public Optional<Product> findById(String id) {
        LOGGER.info("Finding the item by id: " + id);
        return Optional.ofNullable(super.find(id));
    }

    @Override
    public void deleteById(String id) {
        Optional<Product> item = findById(id);
        item.ifPresent((i) -> super.remove(i));
    }
}
