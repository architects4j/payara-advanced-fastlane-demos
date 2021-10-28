package my.compary.fundamentals;


import com.github.javafaker.Address;
import com.github.javafaker.Country;
import com.github.javafaker.Faker;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class FakerService {

    @Inject
    private Faker faker;

    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        Address address = faker.address();
        for (int index = 0; index < 20; index++) {
            cities.add(address.cityName());
        }
        waitTwoSeconds();
        return cities;
    }

    public List<String> getCountries() {
        List<String> countries = new ArrayList<>();
        Country country = faker.country();
        for (int index = 0; index < 20; index++) {
            countries.add(country.name());
        }
        waitTwoSeconds();
        return countries;
    }

    private void waitTwoSeconds() {
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
