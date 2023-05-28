package pl.wszib.pizzamarket.web.mappers;

import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.web.models.PizzaModel;

public class PizzaMapper {
    public static PizzaModel toModel(PizzaEntity entity) {
        return new PizzaModel(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getIngredients());
    }
}
