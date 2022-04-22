package recipe.usecase.search;

import ingredient.entity.Ingredient;
import recipe.entity.MealType;

import java.util.List;

public record RecipeSearchCriteria (String name, MealType type, List<Ingredient> ingredients){
}
