package befaster.runner;

public class NumberLimitExceedException extends RuntimeException {
    public NumberLimitExceedException(){
        super("Number Limit is greater than expected");
    }
}
