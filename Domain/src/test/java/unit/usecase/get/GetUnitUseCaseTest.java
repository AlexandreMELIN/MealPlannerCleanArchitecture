package unit.usecase.get;

import org.junit.jupiter.api.Test;
import unit.entity.Unit;
import unit.port.UnitGet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class GetUnitUseCaseTest implements UnitGet, GetUnitPresenter {

    @Override
    public Unit getUnit(String shortName) {
        if (shortName.equals("L")) {
            return Unit.LITER;
        }
        return null;
    }

    @Override
    public void present(GetUnitResponse response) {

    }

    @Test
    void shouldGetUnit() {
        var unit = this.getUnit("L");
        assertThat(unit.getShortName(), equalTo("L"));
        assertThat(unit.getName(), equalTo("Liter"));
    }

    @Test
    void shouldNotGetAnyUnit() {
        var unit = this.getUnit("X");
        assertThat(unit, equalTo(null));
    }
}