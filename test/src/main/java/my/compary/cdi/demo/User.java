package my.compary.cdi.demo;

import java.util.function.Supplier;

public class User implements Supplier<String> {
    private final String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public String get() {
        return this.username;
    }
}
