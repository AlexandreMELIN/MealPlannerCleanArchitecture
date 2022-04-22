package recipe.usecase.search;

import ingredient.entity.Ingredient;
import recipe.entity.MealType;

import java.util.List;

public record SearchRecipeRequest (RecipeSearchCriteria criteria) {
}
