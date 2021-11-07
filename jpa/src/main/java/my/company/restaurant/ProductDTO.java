package my.company.restaurant;


import my.company.restaurant.infra.FieldPropertyVisibilityStrategy;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbVisibility;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Schema(name = "Item", description = "The entity that represents Item in a restaurant")
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class ProductDTO {

    private Long id;

    @Schema(required = true, name = "name", description = "The product name", example = "water")
    @NotBlank
    @Size(min = 3, max = 20, message = "The name size should be between 3 and 10 chars")
    private String name;

    @Schema(required = true, name = "description", description = "The product description", example = "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.")
    @NotBlank
    @Size(min = 10, max = 100, message = "The description should be between 10 and 100 chars")
    private String description;

    @Schema(required = true, name = "expires", description = "When the product expires", example = "2025-12-03")
    @Future(message = "It is not possible to save an expired item")
    @NotNull
    private LocalDate expires;

    @Schema(required = true, name = "price", description = "The product price", example = "USD 10")
    @NotNull
    private String price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expires=" + expires +
                ", price='" + price + '\'' +
                '}';
    }
}
