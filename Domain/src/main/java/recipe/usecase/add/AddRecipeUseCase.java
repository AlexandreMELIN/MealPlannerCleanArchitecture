package recipe.usecase.add;

import recipe.entity.Recipe;
import recipe.port.RecipeCreate;

public class AddRecipeUseCase {
    private final RecipeCreate recipeCreate;

    public AddRecipeUseCase(RecipeCreate recipeCreate) {
        this.recipeCreate = recipeCreate;
    }

    public void execute(AddRecipeRequest request, AddRecipePresenter presenter) {
        var recipe = new Recipe(
                request.name(),
                request.steps(),
                request.serves(),
                request.type(),
                request.ingredientDetails()
        );
        var recipeResponse = this.recipeCreate.createRecipe(recipe);
        presenter.present(new AddRecipeResponse(recipeResponse));
    }
}
