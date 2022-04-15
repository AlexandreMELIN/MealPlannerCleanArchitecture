package unit.usecase.add;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.entity.Unit;
import unit.port.UnitCreate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



class AddUnitUseCaseTest implements AddUnitPresenter, UnitCreate {

    private Unit createdUnit;

    @BeforeEach
    void setupTest() {
        this.createdUnit = null;
    }

    @Override
    public void present(AddUnitResponse response) {
        this.createdUnit = new Unit(response.unit().name(), response.unit().shortName());
    }

    @Override
    public Unit createUnit(Unit unit) {
        return unit;
    }

    @Test
    void shouldCreateUnit() {
        var useCase = new AddUnitUseCase(this);
        useCase.execute(new AddUnitRequest("Litre", "L"), this);
        assertThat(this.createdUnit.name(), equalTo("Litre"));
        assertThat(this.createdUnit.shortName(), equalTo("L"));
    }
}