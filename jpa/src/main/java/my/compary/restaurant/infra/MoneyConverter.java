package my.compary.restaurant.infra;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.javamoney.moneta.Money;


@Converter
public class MoneyConverter implements AttributeConverter<MonetaryAmount, String> {

    @Override
    public String convertToDatabaseColumn(MonetaryAmount attribute) {

        if (attribute == null) {
            return null;
        }
        return Money.from(attribute).toString();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String dbData){
        if (dbData == null) {
            return null;
        }
        return Money.parse(dbData);
    }

}
