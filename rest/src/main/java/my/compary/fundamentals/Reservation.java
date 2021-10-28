package my.compary.fundamentals;

import my.compary.fundamentals.infra.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import java.time.LocalDate;

@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Reservation {

    private String to;

    private String from;

    private LocalDate start;

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public LocalDate getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", start=" + start +
                '}';
    }
}
