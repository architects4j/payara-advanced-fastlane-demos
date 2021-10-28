package my.compary.fundamentals;


import com.github.javafaker.Address;
import com.github.javafaker.Country;
import com.github.javafaker.Faker;

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

    public List<String> getCities() {
        LOGGER.info("Starting the cities service");
        List<String> cities = new ArrayList<>();
        Address address = faker.address();
        for (int index = 0; index < 20; index++) {
            cities.add(address.cityName());
        }
        waitTwoSeconds();
        return cities;
    }

    public List<String> getCountries() {
        LOGGER.info("Starting the countries service");
        List<String> countries = new ArrayList<>();
        Country country = faker.country();
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
