package ingredient.entity;

import java.util.List;
import unit.entity.Unit;

public record NutritionalValue(NutritionalInformation referenceInformation,
                               Double referenceQuantity, Unit unit,
                               List<NutritionalInformation> details) {
}
