package recipe.usecase.delete;

import recipe.port.RecipeDeleter;

public class DeleteRecipeUseCase {
    private final RecipeDeleter deleter;

    public DeleteRecipeUseCase(RecipeDeleter deleter) {
        this.deleter = deleter;
    }

    public void execute(DeleteRecipeRequest request, DeleteRecipePresenter presenter) {
        if (request.criteria().name() != null) {
            deleter.deleteByName(request.criteria().name());
        }
        presenter.present(new DeleteRecipeResponse());
    }
}
