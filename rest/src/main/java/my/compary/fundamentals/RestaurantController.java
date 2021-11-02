package my.compary.fundamentals;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("restaurants/")
public class RestaurantController {


    @Inject
    private FakerService service;

    @Path("/beers")
    @GET
    public Response getBeers() {

        CacheControl cc = new CacheControl();
        cc.setMaxAge(5);
        cc.setPrivate(true);
        Response.ResponseBuilder builder = Response.ok(service.getBeers());
        builder.cacheControl(cc);
        return builder.build();
    }

    @GET
    @Path("foods")
    public Response getFoods() {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(5);
        cc.setPrivate(true);
        Response.ResponseBuilder builder = Response.ok(service.getFoods());
        builder.cacheControl(cc);
        return builder.build();
    }

    @PATCH
    @Path("foods")
    public Response getTrace() {
        CacheControl cc = new CacheControl();
        cc.setMaxAge(5);
        cc.setPrivate(true);
        Response.ResponseBuilder builder = Response.ok(service.getFoods());
        builder.cacheControl(cc);
        return builder.build();
    }
}
