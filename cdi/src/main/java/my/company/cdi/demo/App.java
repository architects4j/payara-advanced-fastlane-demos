package my.company.cdi.demo;

import my.company.cdi.demo.music.Orchestra;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Orchestra orchestra = container.select(Orchestra.class).get();
            orchestra.percussion();
            orchestra.keyboard();
            orchestra.string();
            orchestra.allSound();

        }
    }
}
