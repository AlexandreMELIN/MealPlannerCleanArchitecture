package recipe.port;

import java.util.UUID;

public interface RecipePresenceChecker {
    boolean exists(UUID recipeUUID);

}
