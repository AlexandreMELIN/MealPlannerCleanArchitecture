package recipe.port;

import ingredient.entity.Ingredient;
import recipe.entity.MealType;
import recipe.entity.Recipe;
import recipe.usecase.search.RecipeSearchCriteria;

import java.util.List;

public interface RecipeSearch {
    List<Recipe> searchBy(RecipeSearchCriteria criteria);
}
