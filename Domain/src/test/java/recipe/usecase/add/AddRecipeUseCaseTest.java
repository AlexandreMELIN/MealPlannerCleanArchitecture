package recipe.usecase.add;

import ingredient.entity.Ingredient;
import ingredient.entity.IngredientType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.entity.IngredientDetail;
import recipe.entity.MealType;
import recipe.entity.Recipe;
import recipe.entity.Step;
import recipe.port.RecipeCreate;
import unit.entity.Unit;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AddRecipeUseCaseTest implements AddRecipePresenter, RecipeCreate {

    private Recipe createdRecipe;

    @BeforeEach
    void setupTest() {
        this.createdRecipe = null;
    }

    @Override
    public void present(AddRecipeResponse response) {
        this.createdRecipe = response.recipe();
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipe;
    }

    @Test
    void shouldCreateARecipe() {
        var ingredientWater = new Ingredient("Eau", IngredientType.DRINK, new ArrayList<>());
        var ingredientWaterDetail = new IngredientDetail(ingredientWater, 30.0, new Unit("Centilitres", "cL"));

        var useCase = new AddRecipeUseCase(this);
        var request = new AddRecipeRequest(
                "Un verre d'eau",
                List.of(new Step(0, "Verser de l'eau dans un verre")),
                1,
                MealType.STARTER,
                List.of(ingredientWaterDetail)
        );
        useCase.execute(request, this);
        assertThat(this.createdRecipe.name(), equalTo("Un verre d'eau"));
        assertThat(this.createdRecipe.steps().size(), equalTo(1));
        assertThat(this.createdRecipe.type(), equalTo(MealType.STARTER));
        assertThat(this.createdRecipe.ingredientDetails().size(), equalTo(1));
    }
}