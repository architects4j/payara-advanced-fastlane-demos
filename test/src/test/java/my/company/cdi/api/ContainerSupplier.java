package my.company.cdi.api;


import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.function.Supplier;
import java.util.stream.Stream;

class ContainerSupplier implements Supplier<SeContainer> {

    private final CDIExtension config;

    ContainerSupplier(CDIExtension config) {
        this.config = config;
    }

    @Override
    public SeContainer get() {
        final SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        if (config.disableDiscovery()) {
            initializer.disableDiscovery();
        }
        initializer.setClassLoader(Thread.currentThread().getContextClassLoader());
        initializer.addBeanClasses(config.classes());
        initializer.enableDecorators(config.decorators());
        initializer.enableInterceptors(config.interceptors());
        initializer.selectAlternatives(config.alternatives());
        initializer.selectAlternativeStereotypes(config.alternativeStereotypes());
        initializer.addPackages(getPackages(config.packages()));
        initializer.addPackages(true, getPackages(config.recursivePackages()));
        return initializer.initialize();
    }

    private Package[] getPackages(Class<?>[] packages) {
        return Stream.of(packages).map(Class::getPackage).toArray(Package[]::new);
    }


}