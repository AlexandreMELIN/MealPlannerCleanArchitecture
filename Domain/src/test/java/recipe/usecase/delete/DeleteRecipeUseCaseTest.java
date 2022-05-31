package recipe.usecase.delete;

import ingredient.entity.Ingredient;
import ingredient.entity.IngredientType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.entity.IngredientDetail;
import recipe.entity.MealType;
import recipe.entity.Recipe;
import recipe.entity.Step;
import recipe.port.RecipeDeleter;
import unit.entity.Unit;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DeleteRecipeUseCaseTest implements RecipeDeleter, DeleteRecipePresenter {
    private Recipe recipe;

    @Override
    public void deleteByName(String recipeName) {
        if (recipeName.contentEquals("chocolate")) {
            recipe = null;
        }
    }

    @Override
    public void present(DeleteRecipeResponse response) {

    }

    @BeforeEach
    void setUp() {
        recipe = new Recipe(
                "chocolate",
                List.of(new Step(0, "Mettre du chocolat")),
                1,
                MealType.SNACK,
                List.of(
                        new IngredientDetail(
                                new Ingredient("chocolat", IngredientType.CONFECTIONERY, null),
                                1.0,
                                Unit.GRAM)));
    }

    @Test
    void shouldDeleteTheRecipeWhenNamesAreMatching() {
        DeleteRecipeUseCase useCase = new DeleteRecipeUseCase(this);
        useCase.execute(new DeleteRecipeRequest(new DeleteRecipeCriteria(recipe.name())), this);
        assertThat(recipe, is(nullValue()));
    }

    @Test
    void shouldNotDeleteTheRecipeWhenNamesAreNotMatching() {
        DeleteRecipeUseCase useCase = new DeleteRecipeUseCase(this);
        useCase.execute(new DeleteRecipeRequest(new DeleteRecipeCriteria("This recipe is a lie")), this);
        assertThat(recipe, is(notNullValue()));
    }
}