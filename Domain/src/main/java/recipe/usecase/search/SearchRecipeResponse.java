package recipe.usecase.search;

import recipe.entity.Recipe;

import java.util.List;

public record SearchRecipeResponse(List<Recipe> recipes) {
}
