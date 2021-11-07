package my.company.fundamentals;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;

@RequestScoped
@Path("restaurants/async")
public class RestaurantAsyncController {

    @Inject
    private ExecutorService executorService;

    @Inject
    private FakerService service;

    @Path("/beers")
    @GET
    public void getReservation(@Suspended AsyncResponse async) {
        executorService.execute(() -> {
            List<Item> beers = service.getBeers();
            async.resume(beers);
        });
    }

    @GET
    @Path("countries")
    public CompletionStage<List<Item>> getCountries() {
        CompletableFuture<List<Item>> future = CompletableFuture
                .supplyAsync(() -> service.getFoods());
        return future;
    }
}
