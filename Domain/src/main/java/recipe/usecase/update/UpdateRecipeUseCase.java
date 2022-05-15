package recipe.usecase.update;

import recipe.port.RecipePresenceChecker;
import recipe.port.RecipeUpdater;

/**
 * Use case to update a recipe. The update method chosen here is to delete and replace.
 */
public class UpdateRecipeUseCase {
    private final RecipeUpdater updater;
    private final RecipePresenceChecker presenceChecker;

    public UpdateRecipeUseCase(RecipeUpdater updater, RecipePresenceChecker presenceChecker) {
        this.updater = updater;
        this.presenceChecker = presenceChecker;
    }

    public void execute(UpdateRecipeRequest request, UpdateRecipePresenter presenter) throws IllegalArgumentException {
        if (!presenceChecker.aRecipeWithThisNameAlreadyExists(request.oldRecipeName())) {
            throw new IllegalArgumentException(String.format("A recipe with the name %s must be present to be updated", request.oldRecipeName()));
        }
        var updatedRecipe = updater.update(request.oldRecipeName(), request.recipeUpdated());
        presenter.present(new UpdateRecipeResponse(updatedRecipe));
    }
}
