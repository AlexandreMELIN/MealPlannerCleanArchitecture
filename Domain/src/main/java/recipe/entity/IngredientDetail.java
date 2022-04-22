package recipe.entity;

import ingredient.entity.Ingredient;
import unit.entity.Unit;

public record IngredientDetail(Ingredient ingredient, Double quantity, Unit unit) {
    public IngredientDetail add(IngredientDetail detailToAdd){
        if (!this.unit.equals(detailToAdd.unit))
            throw new IllegalArgumentException("Ingredient details must have the same unit to be added");

        return new IngredientDetail(ingredient, quantity + detailToAdd.quantity, unit);
    }
}
