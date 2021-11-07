package my.company.restaurant;


import my.company.restaurant.infra.FieldPropertyVisibilityStrategy;
import my.company.restaurant.infra.MoneyConverter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbVisibility;
import javax.money.MonetaryAmount;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;


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

    Product() {
    }

    private Product(Long id, String name, String description, LocalDate expires, MonetaryAmount price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expires = expires;
        this.price = price;
    }

    public void update(Product item, ProductRepository repository) {
        this.description = item.description;
        this.expires = item.expires;
        this.name = item.name;
        repository.save(item);
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

    public LocalDate getExpires() {
        return expires;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", expires=" + expires +
                ", price=" + price +
                '}';
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private Long id;
        private String name;
        private String description;
        private LocalDate expires;
        private MonetaryAmount price;

        private ProductBuilder() {
        }

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder expires(LocalDate expires) {
            this.expires = expires;
            return this;
        }

        public ProductBuilder price(MonetaryAmount price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(id, name, description, expires, price);
        }
    }
}
