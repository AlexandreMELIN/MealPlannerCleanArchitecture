package ingredient.usecase.addIngredient;

import ingredient.entity.Ingredient;
import ingredient.entity.IngredientType;
import ingredient.port.IngredientCreator;
import ingredient.port.IngredientPresenceChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddIngredientUseCaseTest implements AddIngredientPresenter, IngredientPresenceChecker, IngredientCreator {
    private Ingredient ingredient;

    @Override
    public Ingredient create(Ingredient ingredient) {
        return ingredient;
    }

    @Override
    public boolean existsByName(String ingredientName) {
        return ingredientName.contentEquals("pate");
    }

    @Override
    public boolean existsByUUID(UUID ingredientUUID) {
        return false;
    }

    @Override
    public void present(AddIngredientResponse response) {
        ingredient = response.ingredientCreated();
    }

    @BeforeEach
    void setUp() {
        ingredient = null;
    }

    @Test
    void shouldAddIngredient() {
        var ingredientToAdd = new Ingredient("riz", IngredientType.FOOD_STAPLE, null);
        var useCase = new AddIngredientUseCase(this, this);
        useCase.execute(new AddIngredientRequest(ingredientToAdd), this);
        assertThat(ingredientToAdd, is(this.ingredient));
    }

    @Test
    void shouldThrowAnExceptionWhenAnIngredientAlreadyExist() {
        var ingredientToAdd = new Ingredient("pate", IngredientType.FOOD_STAPLE, null);
        var useCase = new AddIngredientUseCase(this, this);
        var exception = assertThrows(IllegalArgumentException.class, () -> useCase.execute(new AddIngredientRequest(ingredientToAdd), this));
        assertThat(exception, is(notNullValue()));
        assertThat(exception.getMessage(), is("An ingredient named pate already exists"));
    }
}