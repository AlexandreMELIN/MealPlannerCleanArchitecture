package recipe.usecase.search;

import recipe.port.RecipeSearch;

public class SearchRecipeUseCase {

    private final RecipeSearch recipeSearch;

    public SearchRecipeUseCase(RecipeSearch recipeSearch) {
        this.recipeSearch = recipeSearch;
    }

    public void execute(SearchRecipeRequest request, SearchRecipePresenter presenter) {
        var recipes = this.recipeSearch.searchBy(request.criteria());
        presenter.present(new SearchRecipeResponse(recipes));
    }
}
