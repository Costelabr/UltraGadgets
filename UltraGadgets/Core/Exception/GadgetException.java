package Exception;

public class GadgetException
  extends RuntimeException
{
  private static final long serialVersionUID = 3178361382172581067L;
  
  public GadgetException() {}
  
  public GadgetException(String message)
  {
    super(message);
  }
}