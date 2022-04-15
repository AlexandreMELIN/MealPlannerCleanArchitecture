package recipe.entity;

import java.util.List;

public record Recipe (String name, List<Step> steps, int serves, MealType type, List<IngredientDetail> ingredientDetails) {}
