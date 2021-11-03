package my.compary.fundamentals;


import com.github.javafaker.Beer;
import com.github.javafaker.Faker;
import com.github.javafaker.Food;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@ApplicationScoped
public class FakerService {

    private static final Logger LOGGER = Logger.getLogger(FakerService.class.getName());

    @Inject
    private Faker faker;

    public List<Item> getBeers() {
        LOGGER.info("Starting the beers service");
        List<Item> beers = new ArrayList<>();
        Beer beer = faker.beer();
        for (int index = 0; index < 20; index++) {
            beers.add(Item.of(beer));
        }
        waitTwoSeconds();
        return beers;
    }

    public List<Item> getFoods() {
        LOGGER.info("Starting the food service");
        List<Item> countries = new ArrayList<>();
        Food food = faker.food();
        for (int index = 0; index < 20; index++) {
            countries.add(Item.of(food));
        }
        waitTwoSeconds();
        return countries;
    }

    private void waitTwoSeconds() {
        LOGGER.info("We'll wait for two seconds");
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
