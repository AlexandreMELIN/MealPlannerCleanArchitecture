package recipe.entity;

import ingredient.entity.Ingredient;
import unit.entity.Unit;

public record IngredientDetail(Ingredient ingredient, Double quantity, Unit unit) {

}
