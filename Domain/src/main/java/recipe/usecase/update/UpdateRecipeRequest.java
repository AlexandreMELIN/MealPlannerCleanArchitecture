package recipe.usecase.update;

import recipe.entity.Recipe;

public record UpdateRecipeRequest(String oldRecipeName, Recipe recipeUpdated) {
}
