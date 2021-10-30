package my.compary.cache.infra;

import my.compary.cache.Item;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
class CacheManagerProducer {

    @Inject
    private CacheManager cacheManager;

    @Produces
    @ApplicationScoped
    Cache<String, Item> getCacheManager() {
        MutableConfiguration<String, Item> config  = new MutableConfiguration<>();
        return cacheManager.createCache("simpleCache", config);
    }

    void close(@Disposes Cache<String, Item> close) {
        close.close();
    }
}
