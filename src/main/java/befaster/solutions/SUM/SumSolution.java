package befaster.solutions.SUM;

import befaster.runner.NegativeNumberNotSupportedException;
import befaster.runner.NumberLimitExceedException;
import befaster.runner.SolutionNotImplementedException;

public class SumSolution {

    public int compute(int x, int y) {

        if(x <0 && y <0){
            throw new NegativeNumberNotSupportedException();
        }
        if(x>100 || y>100){
            throw new NumberLimitExceedException();
        }
        return x+y;

    }

}
