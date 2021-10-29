package my.compary.restaurant;


import my.compary.restaurant.infra.FieldPropertyVisibilityStrategy;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Schema(name = "Item", description = "The entity that represents Item in a restaurant")
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Schema(required = true, name = "name", description = "The product name", example = "water")
    @NotBlank
    @Size(min = 3, max = 20, message = "The name size should be between 3 and 10 chars")
    private String name;

    @Column
    @Schema(required = true, name = "description", description = "The item description", example = "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.")
    @NotBlank
    @Size(min = 10, max = 100, message = "The description should be between 10 and 100 chars")
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    @Schema(required = true, name = "type", description = "The type name", example = "BEVERAGE")
    @NotNull(message = "Fill up it with either BEVERAGE or FOOD")
    private ItemType type;

    @Column(columnDefinition = "DATE")
    @Schema(required = true, name = "expires", description = "When the item expires", example = "2025-12-03")
    @Future(message = "It is not possible to save an expired item")
    @NotNull
    private LocalDate expires;



    public void update(Product item, RestaurantRepository repository) {
        this.description = item.description;
        this.expires = item.expires;
        this.type = item.type;
        this.name = item.name;
        repository.save(item);
    }





}
