package befaster.solutions.TST;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TwoTest {
    private Two two;

    @Before
    public void name() {
        two = new Two();
    }

    @Test
    public void run() {
        assertThat(two.apply(), equalTo(2));
    }

}