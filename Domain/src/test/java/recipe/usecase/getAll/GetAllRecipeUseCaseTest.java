package recipe.usecase.getAll;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import ingredient.entity.Ingredient;
import ingredient.entity.IngredientType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.entity.IngredientDetail;
import recipe.entity.MealType;
import recipe.entity.Recipe;
import recipe.entity.Step;
import recipe.port.RecipeGetAll;
import unit.entity.Unit;

class GetAllRecipeUseCaseTest implements GetAllRecipePresenter, RecipeGetAll {
  private List<Recipe> recipes;

  @BeforeEach
  void reset() {
    recipes = new ArrayList<>();
  }

  @Override
  public List<Recipe> getAll() {
    return List.of(
        new Recipe(
            "Pate bolo",
            List.of(
                new Step(1, "Faire cuire les pates et la viande"),
                new Step(2, "Tu touilles et c'est bon")),
            2,
            MealType.MAIN_COURSE,
            List.of(
                new IngredientDetail(
                    new Ingredient("Pate", IngredientType.FOOD_STAPLE, null), 3000.0, Unit.GRAM),
                new IngredientDetail(
                    new Ingredient("Bolo", IngredientType.MEAT, null), 1.0, Unit.GRAM))),
        new Recipe(
            "Pate carbo",
            List.of(
                new Step(1, "Faire cuire les pates et la carbo"),
                new Step(2, "Tu touilles et c'est bon")),
            2,
            MealType.MAIN_COURSE,
            List.of(
                new IngredientDetail(
                    new Ingredient("Pate complete", IngredientType.FOOD_STAPLE, null),
                    3000.0,
                    Unit.GRAM),
                new IngredientDetail(
                    new Ingredient("Carbo", IngredientType.FOOD_STAPLE, null),
                    1000.0,
                    Unit.GRAM))));
  }

  @Override
  public void present(GetAllRecipeResponse response) {
    this.recipes = response.recipes();
  }

  @Test
  void shouldRetrieveAllRecipes() {
    var getAllUseCase = new GetAllRecipeUseCase(this);
    getAllUseCase.execute(new GetAllRecipeRequest(), this);
    var expectedRecipes = this.getAll();
    expectedRecipes.forEach(
        recipe -> {
          assertThat(this.recipes.contains(recipe), is(true));
        });
  }
}
