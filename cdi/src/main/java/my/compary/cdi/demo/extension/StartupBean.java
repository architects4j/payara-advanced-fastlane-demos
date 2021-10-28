package my.compary.cdi.demo.extension;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@StartUp
public class StartupBean {
    @PostConstruct
    public void onStartup() {
        System.out.println("Application starting up.");
    }
}