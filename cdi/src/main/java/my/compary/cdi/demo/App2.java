package my.compary.cdi.demo;

import my.compary.cdi.demo.load.NameLoaderLazy;
import my.compary.cdi.demo.load.NameLoaderStartup;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Set;
import java.util.function.Supplier;

public class App2 {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            System.out.println("Starting the loaders classes");
            Supplier<Set<String>> loaderLazy = container.select(NameLoaderLazy.class).get();
            Supplier<Set<String>> loaderStartup = container.select(NameLoaderStartup.class).get();
            System.out.println("The fakes names" + loaderLazy.get());
            System.out.println("The fakes names" + loaderStartup.get());

        }
    }
}
