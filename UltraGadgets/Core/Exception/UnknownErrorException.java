package Exception;

public class UnknownErrorException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3010310583452978288L;

	public UnknownErrorException() {}
	
	public UnknownErrorException(String error, Throwable cause) {
		super(error, cause);
		
	}

}
