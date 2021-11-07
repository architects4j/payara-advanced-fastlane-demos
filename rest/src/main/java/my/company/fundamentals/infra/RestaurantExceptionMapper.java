package my.company.fundamentals.infra;

import my.company.fundamentals.RestaurantException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestaurantExceptionMapper implements ExceptionMapper<RestaurantException> {

    @Override
    public Response toResponse(RestaurantException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new Message())
                .build();
    }

    public static class Message {
        private final Long id;
        private final String name;
        private final String description;

        public Message() {
            this.id = 1L;
            this.name = "Error name";
            this.description = "This is a sample of error message description";
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}
