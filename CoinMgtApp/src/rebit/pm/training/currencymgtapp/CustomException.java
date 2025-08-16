package rebit.pm.training.currencymgtapp;



@SuppressWarnings("serial")
public class CustomException extends RuntimeException {

	public CustomException() {
		super("This is a custom exception.");
	}

	public CustomException(String message) {
		super(message);
		
	}


}