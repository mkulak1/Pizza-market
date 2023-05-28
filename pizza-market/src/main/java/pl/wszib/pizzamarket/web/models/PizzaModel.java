package pl.wszib.pizzamarket.web.models;

import java.math.BigDecimal;

public class PizzaModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private String ingredients;

    public PizzaModel(Long id, String name, BigDecimal price, String ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }
}
