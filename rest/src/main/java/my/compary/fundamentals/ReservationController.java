package my.compary.fundamentals;


import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;

@RequestScoped
@Path("reservations")
public class ReservationController {

    private ExecutorService executorService;

    @Path("/cities")
    @GET
    public void getReservation(@QueryParam("from") String from,
                               @QueryParam("to") String to,
                               @QueryParam("start") LocalDate start,
                               @Suspended AsyncResponse async) {


    }
}
