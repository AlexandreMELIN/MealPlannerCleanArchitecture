package recipe.port;

import recipe.entity.Recipe;

import java.util.UUID;

public interface RecipeUpdater {
    Recipe update(UUID recipeUUID, Recipe recipeUpdated);
}
