package recipe.usecase.getAll;

import recipe.entity.Recipe;

import java.util.List;

public record GetAllRecipeRequest(List<Recipe> recipes) {
}
