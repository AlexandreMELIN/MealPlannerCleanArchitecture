package recipe.usecase.search;

import ingredient.entity.Ingredient;
import ingredient.entity.IngredientType;
import org.junit.jupiter.api.Test;
import recipe.entity.IngredientDetail;
import recipe.entity.MealType;
import recipe.entity.Recipe;
import recipe.entity.Step;
import recipe.port.RecipeSearch;
import unit.entity.Unit;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SearchRecipeUseCaseTest implements SearchRecipePresenter, RecipeSearch {

  private Recipe recipe;

  @Override
  public List<Recipe> searchBy(RecipeSearchCriteria criteria) {
    var recipe =
        new Recipe(
            "chocolat",
            List.of(new Step(0, "Mettre du chocolat")),
            1,
            MealType.SNACK,
            List.of(
                new IngredientDetail(
                    new Ingredient("chocolat", IngredientType.CONFECTIONERY, null),
                    1.0,
                    new Unit("g", "gramme"))));
    return List.of(recipe);
  }

  @Override
  public void present(SearchRecipeResponse response) {
    this.recipe = response.recipes().get(0);
  }

  @Test
  void shouldSearchARecipeByName() {
    var searchRecipeUseCase = new SearchRecipeUseCase(this);
    searchRecipeUseCase.execute(
        new SearchRecipeRequest(new RecipeSearchCriteria("chocolate", null, null)), this);

    assertThat(this.recipe.name(), equalTo("chocolat"));
    assertThat(this.recipe.steps().size(), equalTo(1));
    assertThat(this.recipe.type(), equalTo(MealType.SNACK));
    assertThat(this.recipe.ingredientDetails().size(), equalTo(1));
  }
}
