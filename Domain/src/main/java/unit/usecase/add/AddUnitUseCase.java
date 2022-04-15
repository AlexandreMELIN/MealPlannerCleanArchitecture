package unit.usecase.add;

import unit.entity.Unit;
import unit.port.UnitCreate;

public class AddUnitUseCase {

    private final UnitCreate unitCreator;

    public AddUnitUseCase(UnitCreate unitCreator) {
        this.unitCreator = unitCreator;
    }

    public void execute(AddUnitRequest request, AddUnitPresenter presenter) {
        var unit = new Unit(request.name(), request.shortName());
        var unitResponse = this.unitCreator.createUnit(unit);
        presenter.present(new AddUnitResponse(unitResponse));
    }
}
