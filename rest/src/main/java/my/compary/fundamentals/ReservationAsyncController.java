package my.compary.fundamentals;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;

@RequestScoped
@Path("restaurants/async")
public class ReservationAsyncController {

    @Inject
    private ExecutorService executorService;

    @Inject
    private FakerService service;

    @Path("/cities")
    @GET
    public void getReservation(@QueryParam("from") String from,
                               @QueryParam("to") String to,
                               @Suspended AsyncResponse async) {
        executorService.execute(() -> {
            List<String> cities = service.getBeers();
            async.resume(cities);
        });
    }

    @GET
    @Path("countries")
    public CompletionStage<List<String>> getCountries() {
        CompletableFuture<List<String>> future = CompletableFuture
                .supplyAsync(() -> service.getFoods());
        return future;
    }
}
