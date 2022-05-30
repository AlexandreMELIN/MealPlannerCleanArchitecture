package ingredient.port;

import ingredient.entity.Ingredient;

import java.util.List;

public interface IngredientSearcher {
    List<Ingredient> searchAll();
}
