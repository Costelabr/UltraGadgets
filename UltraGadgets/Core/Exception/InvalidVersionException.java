package Exception;

public class InvalidVersionException extends ArrayIndexOutOfBoundsException {

	
	private static final long serialVersionUID = 2952052098611436031L;

	public InvalidVersionException() {}
	
	public InvalidVersionException(String m, Throwable cause) {
		super(m);
	}

}
