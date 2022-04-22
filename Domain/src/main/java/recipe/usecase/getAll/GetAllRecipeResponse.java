package recipe.usecase.getAll;

import java.util.List;
import recipe.entity.Recipe;

public record GetAllRecipeResponse(List<Recipe> recipes) {
}
