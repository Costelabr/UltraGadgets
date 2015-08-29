package Exception;

public class DrawException extends IllegalArgumentException {


	private static final long serialVersionUID = 1L;

	public DrawException(){}
	
	public DrawException(String msg) {
		super(msg);
	}
} 
