package grocerylist.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import ingredient.entity.Ingredient;
import ingredient.entity.IngredientType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipe.entity.IngredientDetail;
import unit.entity.Unit;

class GroceryListTest {
    private GroceryList groceryList;
    @BeforeEach
    void reset(){
        groceryList = new GroceryList();

    }
    private void populateGroceryList(){
        this.groceryList.addIngredientDetail(new IngredientDetail(new Ingredient("pate", IngredientType.FOOD_STAPLE, null), 2.0, Unit.GRAM));
    }
    @Test
    void shouldAddANewIngredientDetailIfNotPresentInAnEmptyList(){
        var ingredientDetailToAdd = new IngredientDetail(new Ingredient("Riz", IngredientType.FOOD_STAPLE, null), 2.0, Unit.GRAM);
        this.groceryList.addIngredientDetail(ingredientDetailToAdd);
        assertThat(this.groceryList.getIngredientsList().contains(ingredientDetailToAdd), is(true));

    }
    @Test
    void shouldAddANewIngredientDetailIfNotPresentInAPopulatedList(){
        populateGroceryList();
        var ingredientDetailToAdd = new IngredientDetail(new Ingredient("Riz", IngredientType.FOOD_STAPLE, null), 2.0, Unit.GRAM);
        this.groceryList.addIngredientDetail(ingredientDetailToAdd);
        assertThat(this.groceryList.getIngredientsList().contains(ingredientDetailToAdd), is(true));
        assertThat(this.groceryList.getIngredientsList().size(), is(2));
    }
    @Test
    void shouldSumQuantitiesWhenAddingAnIngredientAlreadyPresent(){
        populateGroceryList();
        var ingredientDetailToAdd = new IngredientDetail(new Ingredient("pate", IngredientType.FOOD_STAPLE, null), 20.0, Unit.GRAM);
        this.groceryList.addIngredientDetail(ingredientDetailToAdd);
        assertThat(this.groceryList.getIngredientsList().size(), is(1));
        assertThat(this.groceryList.getIngredientsList().get(0).quantity(), is(22.0));
    }




}