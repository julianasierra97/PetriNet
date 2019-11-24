package world;

public class UnsupportedNegativeNumberException extends Exception {
	

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	public UnsupportedNegativeNumberException() {
		super("The specified number cannot be negative");
	}

}
