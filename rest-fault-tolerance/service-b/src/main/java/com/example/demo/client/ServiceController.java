package com.example.demo.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/client/service")
public class ServiceController {

    @GET
    @Path("/{parameter}")
    public String doSomething(@PathParam("parameter") String parameter) throws InterruptedException {
        if(parameter.equalsIgnoreCase("slow")){
            Thread.sleep(5000);
        }
        return String.format("Processed parameter value '%s'", parameter);
    }
}
