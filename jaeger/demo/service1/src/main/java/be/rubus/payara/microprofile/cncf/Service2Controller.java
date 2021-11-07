package be.rubus.payara.microprofile.cncf;

import javax.ws.rs.GET;

public interface Service2Controller {

    @GET
    String doSomething();
}
