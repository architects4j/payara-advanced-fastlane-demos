package my.compary.fundamentals;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;

@RequestScoped
@Path("restaurants/")
public class ReservationController {


    @Inject
    private FakerService service;

    @Path("/cities")
    @GET
    public Response getReservation(@QueryParam("from") String from,
                               @QueryParam("to") String to) {

        CacheControl cc = new CacheControl();
        cc.setMaxAge(5);
        cc.setPrivate(true);
        Response.ResponseBuilder builder = Response.ok(service.getCities());
        builder.cacheControl(cc);
        return builder.build();
    }

    @GET
    @Path("countries")
    public Response getCountries() {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(5);
        cc.setPrivate(true);
        Response.ResponseBuilder builder = Response.ok(service.getCountries());
        builder.cacheControl(cc);
        return builder.build();
    }

    @TRACE
    @Path("countries")
    public Response getTrace() {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(5);
        cc.setPrivate(true);
        Response.ResponseBuilder builder = Response.ok(service.getCountries());
        builder.cacheControl(cc);
        return builder.build();
    }
}
