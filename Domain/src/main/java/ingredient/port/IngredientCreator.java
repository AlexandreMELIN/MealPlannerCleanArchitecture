package ingredient.port;

import ingredient.entity.Ingredient;

public interface IngredientCreator {
    Ingredient create(Ingredient ingredient);
}
