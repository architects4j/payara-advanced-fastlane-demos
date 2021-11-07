package my.company.tolerance;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/resilience")
@ApplicationScoped
public class ResilienceController {

    @Fallback(ErrorMessage.class)
    @Timeout(500)
    @GET
    public String checkTimeout() {
        try {
            Thread.sleep(700L);
        } catch (InterruptedException e) {
            //
        }
        return "Never from normal processing";
    }

    /**
     * The above code-snippet means the method serviceA applies the CircuitBreaker policy,
     * which is to open the circuit once 3 (4x0.75) failures occur among the rolling window
     * of 4 consecutive invocation. The circuit will stay open for 1000ms and then back to half open.
     * After 10 consecutive successful invocations, the circuit will be back to close again.
     */
    @Fallback(CircuitMessage.class)
    @GET
    @Path("circuit")
    @CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 4, failureRatio=0.75,delay = 1000)
    public String getCircuit() {
        try {
            Thread.sleep(700L);
        } catch (InterruptedException e) {
            //
        }
        return "Never from normal processing";
    }
}
