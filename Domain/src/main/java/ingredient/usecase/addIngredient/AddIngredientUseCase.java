package ingredient.usecase.addIngredient;

import ingredient.port.IngredientCreator;
import ingredient.port.IngredientPresenceChecker;

public class AddIngredientUseCase {
    private final IngredientCreator ingredientCreator;
    private final IngredientPresenceChecker checker;

    public AddIngredientUseCase(IngredientCreator ingredientCreator, IngredientPresenceChecker checker) {
        this.ingredientCreator = ingredientCreator;
        this.checker = checker;
    }

    public void execute(AddIngredientRequest request, AddIngredientPresenter presenter) throws IllegalArgumentException {
        if (checker.existsByName(request.ingredientToAdd().name())) {
            throw new IllegalArgumentException(String.format("An ingredient named %s already exists", request.ingredientToAdd().name()));
        }
        presenter.present(new AddIngredientResponse(ingredientCreator.create(request.ingredientToAdd())));

    }
}
