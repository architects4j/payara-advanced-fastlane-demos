package my.compary.restaurant;

import org.javamoney.moneta.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

@Mapper(componentModel = "cdi")
public interface ProductMapper {

    @Mapping(source = "price", target = "price", qualifiedByName = "moneyString")
    @Mapping(source = "expires", target = "expires", qualifiedByName = "localDateString")
    ProductDTO toDTO(Product product);

    @Mapping(source = "price", target = "price", qualifiedByName = "money")
    @Mapping(source = "expires", target = "expires", qualifiedByName = "localDate")
    Product toEntity(ProductDTO dto);

    @Named("money")
    static MonetaryAmount money(String money) {
        if (money == null) {
            return null;
        }
        return Money.parse(money);
    }

    @Named("localDate")
    static LocalDate localDate(String date) {
        if (date == null) {
            return null;
        }
        return LocalDate.parse(date);
    }

    @Named("moneyString")
    static String moneyString(MonetaryAmount money) {
        if (money == null) {
            return null;
        }
        return money.toString();
    }

    @Named("localDateString")
    static String localDateString(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.toString();
    }
}
