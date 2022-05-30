package ingredient.usecase.getAllIngredient;

import ingredient.entity.Ingredient;

import java.util.List;

public record GetAllIngredientResponse(List<Ingredient> ingredients) {
}
