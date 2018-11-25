package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        if(friendName== null) {
            return "Hello, World!";
        }else{
            StringBuilder builder = new StringBuilder();
            builder.append("Hello,");
            builder.append(" "+friendName+"!");
            return builder.toString();
        }

    }
}
