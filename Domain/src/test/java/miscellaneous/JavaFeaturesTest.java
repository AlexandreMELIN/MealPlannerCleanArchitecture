package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JavaFeaturesTest {
    @Test
    void ensureThatForEachOperatorMaintainsTheRightOrderAfterASortOperation() {
        var basedList = new java.util.ArrayList<>(List.of(1, 2, 45, 6));
        Collections.sort(basedList);
        assertThat(basedList.get(0), is(1));
        assertThat(basedList.get(1), is(2));
        assertThat(basedList.get(2), is(6));
        assertThat(basedList.get(3), is(45));
    }
}
