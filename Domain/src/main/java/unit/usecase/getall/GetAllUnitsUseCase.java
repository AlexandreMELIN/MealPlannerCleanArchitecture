package unit.usecase.getall;

import unit.port.UnitGetAll;

public class GetAllUnitsUseCase {

  private final UnitGetAll unitGetter;

  public GetAllUnitsUseCase(UnitGetAll unitGetter) {
    this.unitGetter = unitGetter;
  }

  public void execute(
      GetAllUnitsRequest request, unit.usecase.getall.GetAllUnitsPresenter presenter) {
    var unit = this.unitGetter.getAllUnits();
    presenter.present(new GetAllUnitsResponse(unit));
  }
}
