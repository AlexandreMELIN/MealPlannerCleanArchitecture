package ingredient.usecase.getAllIngredient;

import ingredient.port.IngredientSearcher;

public class GetAllIngredientUseCase {
    private final IngredientSearcher searcher;

    public GetAllIngredientUseCase(IngredientSearcher searcher) {
        this.searcher = searcher;
    }

    public void execute(GetAllIngredientRequest request, GetAllIngredientPresenter presenter) {
        presenter.present(new GetAllIngredientResponse(searcher.searchAll()));
    }
}
