package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        if(friendName== null) {
            throw new SolutionNotImplementedException();
        }
        return "Hello World";
    }
}