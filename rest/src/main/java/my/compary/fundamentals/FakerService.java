package my.compary.fundamentals;


import com.github.javafaker.Address;
import com.github.javafaker.Beer;
import com.github.javafaker.Country;
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

    private static Logger LOGGER = Logger.getLogger(FakerService.class.getName());

    @Inject
    private Faker faker;

    public List<Item> getBeers() {
        LOGGER.info("Starting the cities service");
        List<Item> beers = new ArrayList<>();
        Beer beer = faker.beer();
        for (int index = 0; index < 20; index++) {
            beers.add(Item.of(beer));
        }
        waitTwoSeconds();
        return beers;
    }

    public List<String> getCountries() {
        LOGGER.info("Starting the countries service");
        List<String> countries = new ArrayList<>();
        Food food = faker.food();
        for (int index = 0; index < 20; index++) {
            countries.add(country.name());
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
