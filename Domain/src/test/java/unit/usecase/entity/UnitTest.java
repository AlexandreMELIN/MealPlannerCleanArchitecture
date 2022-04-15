package unit.usecase.entity;

import org.junit.jupiter.api.Test;
import unit.entity.Unit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;



public class UnitTest {

    @Test
    void shouldBeEqual() {
        var unit1 = new Unit("Litre", "L");
        var unit2 = new Unit("Litre", "L");
        assertThat(unit1, equalTo(unit2));
    }
}
