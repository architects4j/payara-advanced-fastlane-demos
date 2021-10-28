package my.compary.tolerance;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import java.util.logging.Logger;

public class ErrorMessage implements FallbackHandler<String> {

    private static final Logger LOGGER = Logger.getLogger(ErrorMessage.class.getName());

    @Override
    public String handle(ExecutionContext context) {
        String message = String.format("The execution method: %s error message %s error message %s",
                context.getMethod().getName(), context.getFailure().getMessage());
        LOGGER.info(message);
        return "Fallback answer due to timeout";
    }
}
