package my.compary.cdi.demo.load;

import com.github.javafaker.DragonBall;
import com.github.javafaker.Faker;
import my.compary.cdi.demo.extension.StartUp;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.Logger;

@ApplicationScoped
@StartUp
public class NameLoaderStartup implements Supplier<Set<String>> {

    private static final Logger LOGGER = Logger.getLogger(NameLoaderStartup.class.getName());

    private final Set<String> names = new HashSet<>();

    @PostConstruct
    public void onStartup() throws InterruptedException {
        LOGGER.info("it will load eagerly");
        TimeUnit.SECONDS.sleep(2L);
        Faker faker = new Faker();
        DragonBall dragonBall = faker.dragonBall();
        for (int index = 0; index < 15; index++) {
            this.names.add(dragonBall.character());
        }
    }

    @Override
    public Set<String> get() {
        return Collections.unmodifiableSet(names);
    }
}