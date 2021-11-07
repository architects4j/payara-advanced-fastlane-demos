package com.example.demo.client;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeoutException;

@Path("/client")
@ApplicationScoped
public class ClientController {

    @Inject
    @RestClient
    private Service service;

    @GET
    @Path("/test/{parameter}")
    @Retry( maxRetries = 3,
            delay = 2, delayUnit = ChronoUnit.SECONDS,
            jitter = 0, jitterDelayUnit = ChronoUnit.SECONDS)
    @Timeout(500)
    public String onClientSide(@PathParam("parameter") String parameter) {
        System.out.println("Invoking client at "+ LocalTime.now());
        return service.doSomething(parameter);
    }

}
