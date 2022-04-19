package recipe.port;

import recipe.entity.Recipe;

public interface RecipeCreate {
    Recipe createRecipe(Recipe recipe);
}
