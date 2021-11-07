package be.rubus.payara.microprofile.cncf;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import java.net.MalformedURLException;
import java.net.URL;

@Path("/service1")
@ApplicationScoped
public class Service1Controller {

    private Service2Controller controller;

    private String exceptionMessage;

    @PostConstruct
    public void init() {
        try {
            controller = RestClientBuilder.newBuilder().baseUrl(new URL("http://service2:8080/data/service2"))
                    .build(Service2Controller.class);
        } catch (MalformedURLException e) {
            exceptionMessage = e.getMessage();
        }
    }

    @GET
    public String testOpenTracing() {
        if (exceptionMessage != null) {
            throw new WebApplicationException(exceptionMessage);
        }
        return controller.doSomething();
    }

}
