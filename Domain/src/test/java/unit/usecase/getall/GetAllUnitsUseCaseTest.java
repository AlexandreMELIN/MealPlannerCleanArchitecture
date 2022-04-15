package unit.usecase.getall;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.entity.Unit;
import unit.port.UnitGetAll;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GetAllUnitsUseCaseTest implements UnitGetAll, GetAllUnitsPresenter {

  private List<Unit> units;

  @BeforeEach
  void setupTest() {
    this.units = new ArrayList<>();
  }

  @Override
  public List<Unit> getAllUnits() {
    return List.of(new Unit("Litre", "L"), new Unit("Gramme", "g"));
  }

  @Override
  public void present(GetAllUnitsResponse response) {
    this.units = response.units();
  }

  @Test
  void shouldGetAllUnits() {
    var useCase = new GetAllUnitsUseCase(this);
    useCase.execute(new GetAllUnitsRequest(), this);
    assertThat(this.units.size(), equalTo(2));
    this.getAllUnits().forEach(unit -> assertThat(this.units.contains(unit), is(true)));
  }
}
