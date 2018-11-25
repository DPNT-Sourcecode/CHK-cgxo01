package befaster.runner;

public class NegativeNumberNotSupportedException extends RuntimeException {
    public NegativeNumberNotSupportedException() {
        super("Negative Number Not Supported");
    }
}
