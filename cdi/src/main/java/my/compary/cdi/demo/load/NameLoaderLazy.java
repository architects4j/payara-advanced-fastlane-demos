package my.compary.cdi.demo.load;

import com.github.javafaker.DragonBall;
import com.github.javafaker.Faker;
import my.compary.cdi.demo.extension.StartUp;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@ApplicationScoped
@StartUp
public class NameLoaderLazy {

    private static final Logger LOGGER = Logger.getLogger(NameLoaderLazy.class.getName());

    private final Set<String> names = new HashSet<>();

    @PostConstruct
    public void onStartup() {
        LOGGER.info("it will load eagerly");
        Faker faker = new Faker();
        DragonBall dragonBall = faker.dragonBall();
        for (int index = 0; index < 15; index++) {
            this.names.add(dragonBall.character());
        }
    }
}