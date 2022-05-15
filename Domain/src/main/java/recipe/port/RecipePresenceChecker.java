package recipe.port;

public interface RecipePresenceChecker {
    boolean aRecipeWithThisNameAlreadyExists(String recipeName);
}
