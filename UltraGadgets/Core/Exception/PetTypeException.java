package Exception;

public class PetTypeException
  extends Exception
{
  

/**
	 * 
	 */
	private static final long serialVersionUID = -8737535346627866745L;

public PetTypeException() {}
  
  public PetTypeException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
