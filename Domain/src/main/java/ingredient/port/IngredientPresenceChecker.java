package ingredient.port;

import java.util.UUID;

public interface IngredientPresenceChecker {
    boolean existsByName(String ingredientName);

    boolean existsByUUID(UUID ingredientUUID);
}
