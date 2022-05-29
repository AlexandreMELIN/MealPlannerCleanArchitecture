package recipe.usecase.update;

import recipe.entity.Recipe;

import java.util.UUID;

public record UpdateRecipeRequest(UUID recipeUUID, Recipe recipeUpdated) {
}
