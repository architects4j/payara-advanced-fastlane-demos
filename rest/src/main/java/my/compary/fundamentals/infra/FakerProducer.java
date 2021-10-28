package my.compary.fundamentals.infra;

import com.github.javafaker.Faker;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class FakerProducer {

    @ApplicationScoped
    Faker getFaker() {
        return new Faker();
    }
}
