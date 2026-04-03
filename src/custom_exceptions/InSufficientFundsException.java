package custom_exceptions;

public class InSufficientFundsException extends Exception{
    public InSufficientFundsException(String message)
    {
        super(message);
    }
}
