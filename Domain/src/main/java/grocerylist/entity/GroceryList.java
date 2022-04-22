package grocerylist.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import recipe.entity.IngredientDetail;

public class GroceryList {
  private final List<IngredientDetail> ingredientsList;

  public GroceryList(List<IngredientDetail> ingredientsList) {
    this.ingredientsList = ingredientsList;
  }

  public GroceryList() {
    this.ingredientsList = new ArrayList<>();
  }

  public List<IngredientDetail> getIngredientsList() {
    return Collections.unmodifiableList(ingredientsList);
  }

  public GroceryList addIngredientDetail(IngredientDetail ingredientDetailToAdd) {
    ingredientsList.stream()
        .filter(
            ingredientDetail ->
                ingredientDetail.ingredient().equals(ingredientDetailToAdd.ingredient()))
        .findFirst()
        .ifPresentOrElse(
            ingredientDetail -> {
              var newIngredient = ingredientDetail.add(ingredientDetailToAdd);
              ingredientsList.remove(ingredientDetail);
              ingredientsList.add(newIngredient);
            },
            () -> {
              ingredientsList.add(ingredientDetailToAdd);
            });
    return this;
  }
}
