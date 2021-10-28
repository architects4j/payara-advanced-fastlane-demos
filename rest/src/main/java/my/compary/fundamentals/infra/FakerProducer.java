package my.compary.fundamentals.infra;

import com.github.javafaker.Faker;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
class FakerProducer {

    @ApplicationScoped
    @Produces
    Faker getFaker() {
        return new Faker();
    }
}
