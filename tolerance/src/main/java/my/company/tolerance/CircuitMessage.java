package my.company.tolerance;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class CircuitMessage implements FallbackHandler<String> {

    @Override
    public String handle(ExecutionContext context) {
        return "Fallback answer due to CircuitBreak";
    }
}
