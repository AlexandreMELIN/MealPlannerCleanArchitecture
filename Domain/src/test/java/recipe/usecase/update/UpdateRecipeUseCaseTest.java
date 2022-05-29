package recipe.usecase.update;

import ingredient.entity.Ingredient;
import ingredient.entity.IngredientType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.entity.IngredientDetail;
import recipe.entity.MealType;
import recipe.entity.Recipe;
import recipe.entity.Step;
import recipe.port.RecipePresenceChecker;
import recipe.port.RecipeUpdater;
import unit.entity.Unit;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UpdateRecipeUseCaseTest implements RecipeUpdater, UpdateRecipePresenter, RecipePresenceChecker {
    private Recipe baseRecipe;
    private final UUID recipeUUID = UUID.randomUUID();
    @BeforeEach
    void setUp() {
        baseRecipe = new Recipe(
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

    @Override
    public boolean exists(UUID recipeUUID) {
        return recipeUUID.equals(this.recipeUUID);
    }

    @Override
    public Recipe update(UUID recipeUUID, Recipe recipeUpdated) {
        if (recipeUUID.equals(this.recipeUUID)) {
            return recipeUpdated;
        }
        return null;
    }

    @Override
    public void present(UpdateRecipeResponse response) {
        baseRecipe = response.recipeUpdated();
    }

    @Test
    void shouldUpdateWhenARecipeWithANameIsAlreadyPresent() {
        var useCase = new UpdateRecipeUseCase(this, this);
        var newRecipe = new Recipe("chocolat", baseRecipe.steps(), baseRecipe.serves(), baseRecipe.type(), baseRecipe.ingredientDetails());
        useCase.execute(new UpdateRecipeRequest(this.recipeUUID, newRecipe), this);
        assertThat(baseRecipe.name(), is("chocolat"));
    }

    @Test
    void shouldThrowAnErrorWhenUpdatingARecipeNotAlreadyExisting() {
        var useCase = new UpdateRecipeUseCase(this, this);
        var newRecipe = new Recipe("chocolat", baseRecipe.steps(), baseRecipe.serves(), baseRecipe.type(), baseRecipe.ingredientDetails());
        var exception = assertThrows(IllegalArgumentException.class, () -> useCase.execute(new UpdateRecipeRequest(UUID.fromString("This UUID is a lie"), newRecipe), this));
        assertThat(exception, is(notNullValue()));
    }

    @Test
    void shouldUpdateEverything() {
        var useCase = new UpdateRecipeUseCase(this, this);
        var newRecipe = new Recipe("chocolat", List.of(new Step(0, "Mettre du chocolat"), new Step(1, "Touiller")), baseRecipe.serves(), baseRecipe.type(), baseRecipe.ingredientDetails());
        useCase.execute(new UpdateRecipeRequest(this.recipeUUID, newRecipe), this);
        assertThat(baseRecipe, is(newRecipe));
    }
}