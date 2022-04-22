package recipe.usecase.getAll;

import recipe.port.RecipeGetAll;

public class GetAllRecipeUseCase {
    private final RecipeGetAll recipeGetter;

    public GetAllRecipeUseCase(RecipeGetAll recipeGetter) {
        this.recipeGetter = recipeGetter;
    }
    public void execute(GetAllRecipeRequest request, GetAllRecipePresenter presenter){
        presenter.present(new GetAllRecipeResponse(recipeGetter.getAll()));
    }
}
