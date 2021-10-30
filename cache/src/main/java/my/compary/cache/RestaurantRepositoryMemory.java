package my.compary.cache;

import javax.cache.Cache;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
class RestaurantRepositoryMemory implements RestaurantRepository {

    private static final Logger LOGGER = Logger.getLogger(RestaurantRepositoryMemory.class.getName());

    @Inject
    private Cache<String, Item> data;

    @Override
    public Collection<Item> getAll() {
        Collection<Item> items = new ArrayList<>();
        Iterator<Cache.Entry<String, Item>> entities = this.data.iterator();
        entities.forEachRemaining(e -> items.add(e.getValue()));
        return items;
    }

    @Override
    public Item save(Item item) {
        Objects.requireNonNull(item, "An item is required");
        this.data.put(item.getName(), item);
        LOGGER.info("The data was updated: " + item);
        return item;
    }

    @Override
    public Optional<Item> findById(String id) {
        LOGGER.info("Finding the item by id: " + id);
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public void deleteById(String id) {
        this.data.remove(id);
    }
}
