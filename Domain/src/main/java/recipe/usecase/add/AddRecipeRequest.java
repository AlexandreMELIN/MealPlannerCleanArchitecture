package recipe.usecase.add;

import recipe.entity.IngredientDetail;
import recipe.entity.MealType;
import recipe.entity.Step;

import java.util.List;

public record AddRecipeRequest(String name, List<Step> steps, int serves, MealType type, List<IngredientDetail> ingredientDetails) {
}
