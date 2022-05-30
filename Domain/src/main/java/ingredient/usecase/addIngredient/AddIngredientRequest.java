package ingredient.usecase.addIngredient;

import ingredient.entity.Ingredient;

public record AddIngredientRequest(Ingredient ingredientToAdd) {
}
