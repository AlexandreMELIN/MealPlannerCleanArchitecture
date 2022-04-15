package ingredient.entity;

import java.util.List;

public record Ingredient (
     String name,
     IngredientType type,
     List<NutritionalValue> nutritionalValues
) {}
