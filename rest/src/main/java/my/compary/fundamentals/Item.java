package my.compary.fundamentals;

import com.github.javafaker.Beer;
import my.compary.fundamentals.infra.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;
import java.util.List;

@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Item {

    private String name;

    private ItemType type;

    private List<String> ingredients;

    public Item() {
    }

    public static Item of(Beer beer) {

        return null;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", ingredients=" + ingredients +
                '}';
    }
}
