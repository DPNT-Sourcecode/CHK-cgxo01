package befaster.solutions.SUM;

import befaster.runner.NegativeNumberNotSupportedException;
import befaster.runner.NumberLimitExceedException;
import befaster.runner.SolutionNotImplementedException;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class SumSolutionTest {
    private SumSolution sum;

    @Before
    public void setUp() {

        sum = new SumSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }

    @Test(expected = NegativeNumberNotSupportedException.class)
    public void computeSumFailifInputNegativeNumber(){
       when(sum.compute(-1,-1)).thenThrow(new NegativeNumberNotSupportedException());
       sum.compute(-1,1);
    }
    @Test(expected = NumberLimitExceedException.class)
    public void computeSumFailIfNumberExceedLimit(){
        when(sum.compute(101,100)).thenThrow(new NumberLimitExceedException());
        sum.compute(101,1);
    }
}
