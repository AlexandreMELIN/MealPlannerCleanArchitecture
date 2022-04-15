package unit.usecase.get;

import unit.port.UnitGet;

public class GetUnitUseCase {

    private final UnitGet unitGetter;

    public GetUnitUseCase(UnitGet unitGetter) {
        this.unitGetter = unitGetter;
    }

    public void execute(GetUnitRequest request, GetUnitPresenter presenter) {
        var unit = this.unitGetter.getUnit(request.shortName());
        presenter.present(new GetUnitResponse(unit));
    }
}
