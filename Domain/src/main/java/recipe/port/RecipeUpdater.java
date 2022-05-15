package recipe.port;

import recipe.entity.Recipe;

public interface RecipeUpdater {
    Recipe update(String oldRecipeName, Recipe recipeUpdated);
}
