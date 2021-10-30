package my.compary.cdi.demo.load;

import com.github.javafaker.Faker;
import com.github.javafaker.Pokemon;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.Logger;

@ApplicationScoped
public class NameLoaderLazy implements Supplier<Set<String>> {

    private static final Logger LOGGER = Logger.getLogger(NameLoaderLazy.class.getName());

    private final Set<String> names = new HashSet<>();

    @PostConstruct
    void onStartup() throws InterruptedException {
        LOGGER.info("it will load lazily");
        TimeUnit.SECONDS.sleep(2L);
        Faker faker = new Faker();
        Pokemon pokemon = faker.pokemon();
        for (int index = 0; index < 15; index++) {
            this.names.add(pokemon.name());
        }
    }

    @Override
    public Set<String> get() {
        return Collections.unmodifiableSet(names);
    }
}