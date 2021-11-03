package my.compary.fundamentals;

import com.github.javafaker.Beer;
import com.github.javafaker.Food;
import my.compary.fundamentals.infra.FieldPropertyVisibilityStrategy;

import javax.json.bind.annotation.JsonbVisibility;

@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Item {

    private String name;

    private ItemType type;

    private String ingredients;

    public Item() {
    }

    private Item(String name, ItemType type, String ingredients) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
    }

    public static Item of(Beer beer) {
        return new Item(beer.name(), ItemType.BEVERAGE, beer.style());
    }

    public static Item of(Food food) {
        return new Item(food.dish(), ItemType.FOOD, food.ingredient());
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
