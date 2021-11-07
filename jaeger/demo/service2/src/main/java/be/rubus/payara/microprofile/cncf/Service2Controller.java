package be.rubus.payara.microprofile.cncf;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import java.util.Random;

@Path("/service2")
@RequestScoped
public class Service2Controller {

    @GET
    public String domSomething() {
        try {
            Thread.sleep(200 + new Random().nextInt(500));
        } catch (InterruptedException e) {
            throw new WebApplicationException(e.getMessage());
        }
        return "Done\n";
    }

}
