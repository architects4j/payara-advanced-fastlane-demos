package my.compary.restaurant;


import my.compary.restaurant.infra.FieldPropertyVisibilityStrategy;
import my.compary.restaurant.infra.MoneyConverter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbVisibility;
import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Schema(name = "Item", description = "The entity that represents Item in a restaurant")
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(columnDefinition = "DATE")
    private LocalDate expires;

    @Column
    @Convert(converter = MoneyConverter.class)
    private MonetaryAmount price;

    public void update(Product item, ProductRepository repository) {
        this.description = item.description;
        this.expires = item.expires;
        this.name = item.name;
        repository.save(item);
    }


}
